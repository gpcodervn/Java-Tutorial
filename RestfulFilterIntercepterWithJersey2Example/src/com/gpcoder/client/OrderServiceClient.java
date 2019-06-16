package com.gpcoder.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import com.gpcoder.filter.CheckClientRequestFilter;
import com.gpcoder.filter.CheckClientResponseFilter;

public class OrderServiceClient {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";
	public static final String API_TOKEN = "gpcoder-token";

	public static void main(String[] args) {
		callApiWithoutFilter();
		System.out.println("------");
		callApiWithFilter();
	}

	public static void callApiWithFilter() {
		ClientConfig clientConfig = new ClientConfig();

		// Config logging for client side
		clientConfig.register( //
				new LoggingFeature( //
						Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
						Level.INFO, //
						LoggingFeature.Verbosity.PAYLOAD_ANY, //
						10000));

		// Config filters
		clientConfig.register(new CheckClientRequestFilter());
		clientConfig.register(new CheckClientResponseFilter());

		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target(API_URL).path("1");

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		// Don't need to add this line because it's already added automatically by CheckClientRequestFilter
		// invocationBuilder.header("Authorization", "Bearer " + API_TOKEN);

		final Response response = invocationBuilder.delete();
		System.out.println("Header added by CheckClientResponseFilter: " + response.getHeaderString("X-Test-Client"));
		System.out.println("Call delete() successful with the result: " + response.readEntity(String.class));
	}

	public static void callApiWithoutFilter() {
		ClientConfig clientConfig = new ClientConfig();

		// Config logging for client side
		clientConfig.register( //
				new LoggingFeature( //
						Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
						Level.INFO, //
						LoggingFeature.Verbosity.PAYLOAD_ANY, //
						10000));

		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget target = client.target(API_URL).path("1");

		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		invocationBuilder.header("Authorization", "Bearer " + API_TOKEN);

		String result = invocationBuilder.delete(String.class);
		System.out.println("Call delete() successful with the result: " + result);
	}
}
