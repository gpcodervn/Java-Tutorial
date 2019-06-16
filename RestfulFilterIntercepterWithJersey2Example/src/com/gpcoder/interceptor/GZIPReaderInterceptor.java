package com.gpcoder.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

import com.gpcoder.util.ZipUtil;

@Provider
public class GZIPReaderInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException {
		final InputStream originalInputStream = context.getInputStream();
		context.setInputStream(ZipUtil.decompressStream(originalInputStream));
		return context.proceed();
	}
}