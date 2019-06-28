package com.gpcoder.handler;

import com.google.gson.Gson;

import feign.Response;
import feign.codec.ErrorDecoder;

public class MyErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.println("methodKey: " + methodKey);
		System.out.println("response: " + new Gson().toJson(response));
		
		// If your exception is retryable, wrap or subclass RetryableException
		return null;
	}

}
