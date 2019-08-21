package com.gpcoder.helper;

import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.gpcoder.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwTokenHelper {

	// The privateKey is only valid for the given minutes
	private static final long EXPIRATION_LIMIT_IN_MINUTES = 30;

	// The JWT signature algorithm we will be using to sign the token
	private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

	// Keys used with HS256 MUST have a size >= 256 bits
	private static final String SECRET_KEY = "gpcoderdotcom-token-base-authentication-with-jwt-example";

	private static final String ISSUER = "https://gpcoder.com";

	private JwTokenHelper() {
		super();
	}

	public static String createJWT(User user) {

		// Get the current time
		long currentTimeInMillis = System.currentTimeMillis();
		Date now = new Date(currentTimeInMillis);

		// The privateKey is only valid for the next EXPIRATION_LIMIT_IN_MINUTES
		long expirationTimeInMilliSeconds = TimeUnit.MINUTES.toMillis(EXPIRATION_LIMIT_IN_MINUTES);
		Date expirationDate = new Date(currentTimeInMillis + expirationTimeInMilliSeconds);

		// Will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, SIGNATURE_ALGORITHM.getJcaName());

		// Sets the JWT Claims sub (subject) value
		Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("roles", user.getRoles());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder() // Configured and then used to create JWT compact serialized strings
				.setClaims(claims).setId(UUID.randomUUID().toString()) // Sets the JWT Claims jti (JWT ID) value
				.setIssuedAt(now) // Sets the JWT Claims iat (issued at) value
				.setIssuer(ISSUER) // Sets the JWT Claims iss (issuer) value
				.setExpiration(expirationDate) // Sets the JWT Claims exp (expiration) value
				.signWith(signingKey, SIGNATURE_ALGORITHM);

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	/**
	 * Get User from the given token
	 */
	public static User getUserFromToken(String token) {
		final Claims claims = decodeJWT(token);
		User user = new User();
		user.setUsername(claims.getSubject());
		user.setRoles((List<String>) claims.get("roles"));
		return user;
	}

	/**
	 * Check if the token was issued by the server and if it's not expired
	 */
	public static Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private static Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private static <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = decodeJWT(token);
		return claimsResolver.apply(claims);
	}

	private static Claims decodeJWT(String jwt) {
		// This line will throw an exception if it is not a signed JWS (as expected)
		return Jwts.parser() // Configured and then used to parse JWT strings
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)) // Sets the signing key used to verify
																				// any discovered JWS digital signature
				.parseClaimsJws(jwt) // Parses the specified compact serialized JWS string based
				.getBody();
	}
}
