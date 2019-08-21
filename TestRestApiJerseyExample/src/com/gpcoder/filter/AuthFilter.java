package com.gpcoder.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.gpcoder.helper.JwTokenHelper;
import com.gpcoder.model.BasicSecurityConext;
import com.gpcoder.model.User;

/**
 * This filter verify the access permissions for a user based on the token-based
 * authentication
 * 
 * -------------------------------------<br/>
 * How token-based authentication works <br/>
 * -------------------------------------<br/>
 * 
 * In token-based authentication, the client exchanges hard credentials (such as
 * username and password) for a piece of data called token. For each request,
 * instead of sending the hard credentials, the client will send the token to
 * the server to perform authentication and then authorization.
 * 
 * An authentication scheme based on tokens follow these steps:
 * 
 * (1) The client sends their credentials (username and password) to the server.
 * 
 * (2) The server authenticates the credentials and, if they are valid, generate
 * a token for the user.
 * 
 * (3) The server stores the previously generated token in some storage along
 * with the user identifier and an expiration date.
 * 
 * (4) The server sends the generated token to the client.
 * 
 * (5) The client sends the token to the server in each request.
 * 
 * (6) The server, in each request, extracts the token from the incoming
 * request. With the token, the server looks up the user details to perform
 * authentication.
 * 
 * (6.1) If the token is valid, the server accepts the request.
 * 
 * (6.2) If the token is invalid, the server refuses the request.
 *
 * (7) Once the authentication has been performed, the server performs
 * authorization.
 * 
 * (8) The server can provide an endpoint to refresh tokens.
 * 
 * Note: The step (3) is not required if the server has issued a signed token
 * (such as JWT, which allows you to perform stateless authentication).
 * 
 * @see https://stackoverflow.com/questions/26777083/best-practice-for-rest-token-based-authentication-with-jax-rs-and-jersey
 */
@Provider
@Priority(Priorities.AUTHENTICATION) // needs to happen before authorization
public class AuthFilter implements ContainerRequestFilter {

	private static final String REALM = "gpcoder";
	private static final String AUTHENTICATION_SCHEME = "Bearer";

	/**
	 * Extracting the token from the request and validating it
	 * 
	 * The client should send the token in the standard HTTP Authorization header of
	 * the request. For example: Authorization: Bearer <token-goes-here>
	 * 
	 * Finally, set the security context of the current request
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		// (1) Get Token Authorization from the header
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		// (2) Validate the Authorization header
		if (!isTokenBasedAuthentication(authorizationHeader)) {
			return;
		}

		// (3) Extract the token from the Authorization header
		String token = authorizationHeader.substring(AUTHENTICATION_SCHEME.length()).trim();

		try {

			// (4) Validate the token
			if (JwTokenHelper.isTokenExpired(token)) {
				abortWithUnauthorized(requestContext);
				return;
			}

			// (5) Getting the User information from token
			User user = JwTokenHelper.getUserFromToken(token);

			// (6) Overriding the security context of the current request
			SecurityContext oldContext = requestContext.getSecurityContext();
			requestContext.setSecurityContext(new BasicSecurityConext(user, oldContext.isSecure()));
		} catch (Exception e) {
			abortWithUnauthorized(requestContext);
		}
	}

	private boolean isTokenBasedAuthentication(String authorizationHeader) {

		// Check if the Authorization header is valid
		// It must not be null and must be prefixed with "Bearer" plus a whitespace
		// The authentication scheme comparison must be case-insensitive
		return authorizationHeader != null
				&& authorizationHeader.toLowerCase().startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
	}

	private void abortWithUnauthorized(ContainerRequestContext requestContext) {

		// Abort the filter chain with a 401 status code response
		// The WWW-Authenticate header is sent along with the response
		Response respone = Response.status(Response.Status.UNAUTHORIZED) // 401 Unauthorized
				.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
				.entity("You cannot access this resource") // the response entity
				.build();
		requestContext.abortWith(respone);
	}
}