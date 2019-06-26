package com.gpcoder;

import java.io.IOException;

import com.gpcoder.service.AuthenticationClient;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientExample {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	private static OkHttpClient client;
	
	public static void main(String[] args) throws IOException {
		client = new OkHttpClient();
		String token = AuthenticationClient.TOKEN;
		createOrder(token);
		retrieveOrder(token);
		updateOrder(token);
		deleteOrder(token);
	}
	
	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder(String token) throws IOException {
		RequestBody requestBody = RequestBody.create(JSON, createJsonData());
		
		Request request = new Request.Builder()
				.header("Authorization", "Bearer " + token)
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
	private static void retrieveOrder(String token) throws IOException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
		urlBuilder.addPathSegment("1");
		String url = urlBuilder.build().toString();
		
		Request request = new Request.Builder()
				.header("Authorization", "Bearer " + token)
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
	private static void updateOrder(String token) throws IOException {
		RequestBody requestBody = RequestBody.create(JSON, createJsonData());
		
		Request request = new Request.Builder()
				.header("Authorization", "Bearer " + token)
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
	private static void deleteOrder(String token) throws IOException {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
		urlBuilder.addPathSegment("1");
		String url = urlBuilder.build().toString();
		
		Request request = new Request.Builder()
				.header("Authorization", "Bearer " + token)
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
