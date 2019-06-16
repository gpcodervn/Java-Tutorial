package com.gpcoder.interceptor;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Priority(10)
@Provider
public class Priority1ReaderInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException {
		System.out.println("#1 Priority1ReaderInterceptor running ... ");
		return context.proceed();
	}
}