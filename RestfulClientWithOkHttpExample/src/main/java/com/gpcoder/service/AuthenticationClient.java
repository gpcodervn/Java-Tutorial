package com.gpcoder.service;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * This is a first step in restful flow. We must authorize first and use the token for other request.
 */
public class AuthenticationClient {

	public static final String AUTH_URL = "http://localhost:8080/RestfulWebServiceExample/rest/auth";
	public static final String TOKEN = getToken();
	
	/**
	 * Get Json Web Token (JWT)
	 * 
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/auth
	 */
	private static String getToken() {
		RequestBody requestBody = new FormBody.Builder()
		        .add("username", "gpcoder")
		        .add("password", "gpcoder")
		        .build();

		Request request = new Request.Builder()
		        .url(AUTH_URL)
		        .post(requestBody)
		        .build();
		
		OkHttpClient client = new OkHttpClient();
		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected code: " + response);
			}
			String token = response.body().string();
			System.out.println("Token: " + token);
			return token;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
