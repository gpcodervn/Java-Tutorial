package com.gpcoder.client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.interceptor.GZIPWriterInterceptor;
import com.gpcoder.model.Order;

public class InterceptorClient {
	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();

		// Config logging for client side
		clientConfig.register( //
				new LoggingFeature( //
						Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
						Level.INFO, //
						LoggingFeature.Verbosity.PAYLOAD_ANY, //
						10000));

		// Config filters
		clientConfig.register(new GZIPWriterInterceptor());

		String payload = convertToJson(new Order(1, "gpcoder"));

		Client client = ClientBuilder.newClient(clientConfig);
		Response response = client.target(API_URL).request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(payload, MediaType.APPLICATION_JSON));
		System.out.println(response.readEntity(String.class));
	}

	private static String convertToJson(Order order) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
