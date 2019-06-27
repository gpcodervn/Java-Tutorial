package com.gpcoder;

import java.io.IOException;

import com.gpcoder.helper.RetrofitClientCreator;
import com.gpcoder.model.Order;
import com.gpcoder.service.AuthService;
import com.gpcoder.service.OrderService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitClientExample {

	private static Retrofit retrofit;

	public static void main(String[] args) throws IOException {
		retrofit = RetrofitClientCreator.getClient();
		String token = getToken();
		String authentication = "Bearer " + token;

		createOrder(authentication);
		retrieveOrder(authentication);
		updateOrder(authentication);
		deleteOrder(authentication);
	}

	private static String getToken() throws IOException {
		// Create an implementation of the API endpoints defined by the service interface
		AuthService authService = retrofit.create(AuthService.class);

		// Create an invocation of a Retrofit method that sends a request to a webserver
		// and returns a response.
		Call<ResponseBody> call = authService.getToken("gpcoder", "gpcoder");

		// Synchronously send the request and return its response
		Response<ResponseBody> response = call.execute();
		String token = response.body().string();
		System.out.println("getToken: " + token);
		return token;
	}

	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder(String authentication) throws IOException {
		OrderService orderService = retrofit.create(OrderService.class);
		Call<ResponseBody> call = orderService.getOrder(1, authentication);
		Response<ResponseBody> response = call.execute();
		System.out.println("createOrder: " + response.body().string());
	}

	/**
	 * @GET http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void retrieveOrder(String authentication) throws IOException {
		OrderService orderService = retrofit.create(OrderService.class);
		Call<ResponseBody> call = orderService.createOrder(new Order(), authentication);
		Response<ResponseBody> response = call.execute();
		System.out.println("retrieveOrder: " + response.body().string());
	}

	/**
	 * @PUT http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void updateOrder(String authentication) throws IOException {
		OrderService orderService = retrofit.create(OrderService.class);
		Call<ResponseBody> call = orderService.updateOrder(new Order(), authentication);
		Response<ResponseBody> response = call.execute();
		System.out.println("updateOrder: " + response.body().string());
	}

	/**
	 * @DELETE http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void deleteOrder(String authentication) throws IOException {
		OrderService orderService = retrofit.create(OrderService.class);
		Call<ResponseBody> call = orderService.deleteOrder(1, authentication);
		Response<ResponseBody> response = call.execute();
		System.out.println("deleteOrder: " + response.body().string());
	}
}
