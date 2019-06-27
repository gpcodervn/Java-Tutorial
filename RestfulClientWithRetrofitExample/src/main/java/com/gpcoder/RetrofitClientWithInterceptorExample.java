package com.gpcoder;

import java.io.IOException;

import com.gpcoder.helper.RetrofitClientCreator;
import com.gpcoder.model.Order;
import com.gpcoder.service.OrderServiceV2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitClientWithInterceptorExample {

	private static Retrofit retrofit;

	public static void main(String[] args) throws IOException {
		retrofit = RetrofitClientCreator.getClientWithInterceptor();
		createOrder();
		retrieveOrder();
		updateOrder();
		deleteOrder();
	}

	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder() throws IOException {
		OrderServiceV2 orderService = retrofit.create(OrderServiceV2.class);
		Call<ResponseBody> call = orderService.getOrder(1);
		Response<ResponseBody> response = call.execute();
		System.out.println("createOrder: " + response.body().string());
	}

	/**
	 * @GET http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void retrieveOrder() throws IOException {
		OrderServiceV2 orderService = retrofit.create(OrderServiceV2.class);
		Call<ResponseBody> call = orderService.createOrder(new Order());
		Response<ResponseBody> response = call.execute();
		System.out.println("retrieveOrder: " + response.body().string());
	}

	/**
	 * @PUT http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void updateOrder() throws IOException {
		OrderServiceV2 orderService = retrofit.create(OrderServiceV2.class);
		Call<ResponseBody> call = orderService.updateOrder(new Order());
		Response<ResponseBody> response = call.execute();
		System.out.println("updateOrder: " + response.body().string());
	}

	/**
	 * @DELETE http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void deleteOrder() throws IOException {
		OrderServiceV2 orderService = retrofit.create(OrderServiceV2.class);
		Call<ResponseBody> call = orderService.deleteOrder(1);
		Response<ResponseBody> response = call.execute();
		System.out.println("deleteOrder: " + response.body().string());
	}
}
