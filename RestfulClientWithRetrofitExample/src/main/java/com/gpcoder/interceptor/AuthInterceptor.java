package com.gpcoder.interceptor;

import java.io.IOException;

import com.gpcoder.helper.RetrofitClientCreator;
import com.gpcoder.service.AuthService;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class AuthInterceptor implements Interceptor {
	
	private static String token = null;

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
		if (!originalRequest.url().toString().contains("/auth") && getToken() != null) {
			authRequest = originalRequest.newBuilder()
					.header("Authorization", "Bearer " + getToken())
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

	private String getToken() throws IOException {
		if (token != null) {
			return token;
		}
		
		Retrofit retrofit = RetrofitClientCreator.getClientWithInterceptor();
		
		// Create an implementation of the API endpoints defined by the service interface
		AuthService authService = retrofit.create(AuthService.class);

		// Create an invocation of a Retrofit method that sends a request to a webserver
		// and returns a response.
		Call<ResponseBody> call = authService.getToken("gpcoder", "gpcoder");

		// Synchronously send the request and return its response
		retrofit2.Response<ResponseBody> response = call.execute();
		String token = response.body().string();
		System.out.println("getToken: " + token);
		return token;
	}
}
