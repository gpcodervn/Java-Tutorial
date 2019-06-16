package com.gpcoder.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("PoweredByResponseFilter running ... ");
		responseContext.getHeaders().add("X-Api-Version", "2.x");
		responseContext.getHeaders().add("X-Powered-By", "api.gpcoder.com");
	}
}
