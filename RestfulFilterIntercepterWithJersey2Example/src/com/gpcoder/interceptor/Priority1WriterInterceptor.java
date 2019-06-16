package com.gpcoder.interceptor;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

@Priority(10)
@Provider
public class Priority1WriterInterceptor implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException {
		System.out.println("#1 Priority1WriterInterceptor running ... ");
		context.proceed();
	}
}