package com.gpcoder.filter;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.gpcoder.model.BasicSecurityConext;
import com.gpcoder.model.User;
import com.gpcoder.service.UserService;

/**
 * This filter verify the access permissions for a user based on username and
 * password provided in request
 */
@Provider
@Priority(Priorities.AUTHENTICATION) // needs to happen before authorization
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext containerRequest)
			throws WebApplicationException, UnsupportedEncodingException {

		// (1) Parsing the Basic Auth Authorization header
		// The structure of authentication header:
		// Authorization: Basic encodedByBase64(username:password)
		String authCredentials = containerRequest.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (null == authCredentials) {
			return;
		}

		// (2) Extract user name and password from Authentication header
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
		String usernameAndPassword = new String(decodedBytes, "UTF-8");

		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// (3) Getting the User with the username
		UserService userService = new UserService();
		User user = userService.getUser(username);

		// (4) Doing authentication
		if (user == null || !user.getPassword().equals(password)) {
			Response respone = Response.status(Response.Status.UNAUTHORIZED) // 401 Unauthorized
					.entity("You cannot access this resource") // the response entity
					.build();
			containerRequest.abortWith(respone);
		}

		// (5) Setting a new SecurityContext
		SecurityContext oldContext = containerRequest.getSecurityContext();
		containerRequest.setSecurityContext(new BasicSecurityConext(user, oldContext.isSecure()));
	}
}