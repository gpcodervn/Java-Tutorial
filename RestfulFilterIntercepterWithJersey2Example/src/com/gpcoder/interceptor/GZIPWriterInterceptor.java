package com.gpcoder.interceptor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import com.gpcoder.annotation.Compress;

// interceptor will be executed only when resource methods
// annotated with @Compress annotation will be executed
@Compress
@Provider
public class GZIPWriterInterceptor implements WriterInterceptor {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException {
		final OutputStream outputStream = context.getOutputStream();
		context.setOutputStream(new GZIPOutputStream(outputStream));
		context.proceed();
	}
}