package com.gpcoder;

import java.io.IOException;

import com.gpcoder.interceptor.AuthInterceptor;
import com.gpcoder.interceptor.LoggingInterceptor;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientWithInterceptorExample {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	private static OkHttpClient client;
	
	public static void main(String[] args) throws IOException {
		client = new OkHttpClient.Builder()
				.addInterceptor(new LoggingInterceptor())
			    .addInterceptor(new AuthInterceptor())
			    .addNetworkInterceptor(new LoggingInterceptor())
			    .build();
		
		createOrder();
		retrieveOrder();
		updateOrder();
		deleteOrder();
	}
	
	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder() throws IOException {
		RequestBody requestBody = RequestBody.create(JSON, createJsonData());
		
		Request request = new Request.Builder()
				.url(API_URL)
				.post(requestBody)
				.build();

		try (Response response = client.newCall(request).execute()) {
			String result = response.body().string();
			System.out.println("createOrder: " + result);
		}
	}
	
	/**
	 * @GET http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void retrieveOrder() throws IOException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
		urlBuilder.addPathSegment("1");
		String url = urlBuilder.build().toString();
		
		Request request = new Request.Builder()
				.url(url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			String result = response.body().string();
			System.out.println("retrieveOrder: " + result);
		}
	}
	
	/**
	 * @PUT http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void updateOrder() throws IOException {
		RequestBody requestBody = RequestBody.create(JSON, createJsonData());
		
		Request request = new Request.Builder()
				.url(API_URL)
				.post(requestBody)
				.build();

		try (Response response = client.newCall(request).execute()) {
			String result = response.body().string();
			System.out.println("updateOrder: " + result);
		}
	}
	
	/**
	 * @DELETE http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void deleteOrder() throws IOException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
		urlBuilder.addPathSegment("1");
		String url = urlBuilder.build().toString();
		
		Request request = new Request.Builder()
				.url(url)
				.delete()
				.build();

		try (Response response = client.newCall(request).execute()) {
			String result = response.body().string();
			System.out.println("deleteOrder: " + result);
		}
	}
	
	private static String createJsonData() {
		return "{\"id\": 1, \"name\": \"gpcoder\"}";
	}
}
