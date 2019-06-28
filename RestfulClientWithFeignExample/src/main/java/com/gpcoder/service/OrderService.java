package com.gpcoder.service;

import java.util.ArrayList;
import java.util.List;

import com.gpcoder.model.Order;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({
	"Accept: application/json; charset=utf-8",
	"Content-Type: application/json" })
public interface OrderService {

	@RequestLine("GET /orders/{id}")
	String getOrder(@Param("id") int id);

	@RequestLine("POST /orders")
	String createOrder(Order order);

	@RequestLine("PUT /orders")
	String updateOrder(Order order);

	@RequestLine("DELETE /orders/{id}")
	String deleteOrder(@Param("id") int id);

	default List<String> getOrders(int... ids) {
		List<String> orders = new ArrayList<>();
		for (int id : ids) {
			orders.add(this.getOrder(id));
		}
		return orders;
	}
}
