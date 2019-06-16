package com.gpcoder.filter;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;

public class CheckClientRequestFilter implements ClientRequestFilter {

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		System.out.println("CheckClientRequestFilter running ... ");
		String authorization = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorization == null || authorization.trim().isEmpty()) {
			requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer gpcoder-token");
		}
	}
}