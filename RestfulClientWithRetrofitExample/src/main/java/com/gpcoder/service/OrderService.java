package com.gpcoder.service;

import com.gpcoder.model.Order;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface OrderService {

	@GET("orders/{id}")
	Call<ResponseBody> getOrder(@Path("id") int id, @Header("Authorization") String authorization);

	@POST("orders")
	Call<ResponseBody> createOrder(@Body Order order, @Header("Authorization") String authorization);

	@PUT("orders")
	Call<ResponseBody> updateOrder(@Body Order order, @Header("Authorization") String authorization);

	@DELETE("orders/{id}")
	Call<ResponseBody> deleteOrder(@Path("id") int id, @Header("Authorization") String authorization);
}
