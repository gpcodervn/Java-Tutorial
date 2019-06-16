package com.gpcoder.interceptor;

import java.io.IOException;

import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

public class RequestClientWriterInterceptor implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException {
		context.getOutputStream() //
				.write(("Message added in the writer interceptor in the client side") //
				.getBytes());
		context.proceed();
	}
}