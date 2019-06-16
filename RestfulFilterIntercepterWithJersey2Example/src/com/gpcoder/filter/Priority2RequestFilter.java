package com.gpcoder.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Priority(20)
@Provider
public class Priority2RequestFilter implements ClientRequestFilter {

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		System.out.println("#2 Priority2RequestFilter running ... ");
	}
}