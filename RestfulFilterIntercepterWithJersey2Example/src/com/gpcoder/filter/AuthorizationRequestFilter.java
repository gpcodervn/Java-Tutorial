package com.gpcoder.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthorizationRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("AuthorizationRequestFilter running ... ");

		// Must be logged-in to perform the delete action
		if ("DELETE".equals(requestContext.getMethod()) 
				&& !hasToken(requestContext)) {
			Response response = Response.status(Response.Status.UNAUTHORIZED) //
					.entity("User cannot access the resource.") //
					.build();
			requestContext.abortWith(response);
		}
	}

	private boolean hasToken(ContainerRequestContext requestContext) {
		// Extract Authorization header details
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
			return false;
		}
		// Extract the token
		String token = authorizationHeader.substring("Bearer".length()).trim();
		System.out.println("token: " + token);
		return token != null && token.trim().length() > 0;
	}
}