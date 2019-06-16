package com.gpcoder.interceptor;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Priority(20)
@Provider
public class Priority2ReaderInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		System.out.println("#1 Priority1ReaderInterceptor running ... ");
		return context.proceed();
	}
}