package com.gpcoder.interceptor;

import java.io.IOException;

import com.gpcoder.service.AuthenticationClient;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		/*
		 * chain.request() returns original request that you can work with(modify,
		 * rewrite)
		 */
		Request originalRequest = chain.request();

		// Here we can rewrite the request
		// We add an Authorization header if the request is not an authorize request and already had a token
		Request authRequest = originalRequest;
		if (!originalRequest.url().toString().contains("/auth") && AuthenticationClient.TOKEN != null) {
			authRequest = originalRequest.newBuilder()
					.header("Authorization", "Bearer " + AuthenticationClient.TOKEN)
			        .build();
		}
		
		/*
		 * chain.proceed(request) is the call which will initiate the HTTP work. This
		 * call invokes the request and returns the response as per the request.
		 */
		Response response = chain.proceed(authRequest);
		
		// Here we can rewrite/modify the response
		
		return response;
	}
}
