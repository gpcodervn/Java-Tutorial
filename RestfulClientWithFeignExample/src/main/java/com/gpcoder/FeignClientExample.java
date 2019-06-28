package com.gpcoder;

import java.io.IOException;

import com.gpcoder.helper.FeignClientCreator;
import com.gpcoder.model.Order;
import com.gpcoder.service.OrderService;

public class FeignClientExample {

	private static OrderService orderService;

	public static void main(String[] args) throws IOException {
		orderService = FeignClientCreator.getOrderService(OrderService.class);

		createOrder();
		retrieveOrder();
		updateOrder();
		deleteOrder();
		retrieveOrders();
	}

	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder() throws IOException {
		System.out.println("createOrder: " + orderService.createOrder(new Order()));
	}

	/**
	 * @GET http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void retrieveOrder() throws IOException {
		System.out.println("retrieveOrder: " + orderService.getOrder(1));
	}

	/**
	 * @PUT http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void updateOrder() throws IOException {
		System.out.println("updateOrder: " + orderService.updateOrder(new Order()));
	}

	/**
	 * @DELETE http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void deleteOrder() throws IOException {
		System.out.println("deleteOrder: " + orderService.deleteOrder(1));
	}

	private static void retrieveOrders() {
		System.out.println("retrieveOrders: " + orderService.getOrders(1, 2));
	}
}
