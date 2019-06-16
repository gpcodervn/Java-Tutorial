package com.gpcoder.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("PreMatchingFilter running ... ");
		if (requestContext.getMethod().equals("PUT")) {
			System.out.println("Change PUT methods to POST");
			requestContext.setMethod("POST");
		}
	}
}