package com.gpcoder.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

public class OrderServiceClient {

	public static final String AUTH_URL = "http://localhost:8080/RestfulWebServiceExample/rest/auth";
	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";

	public static void main(String[] args) {

		// (1) Authenticate and get token
		final String token = getToken();

		// (2) Call @DELETE API
		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL).path("1");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		invocationBuilder.header("Authorization", "Bearer " + token);
		final Response response = invocationBuilder.delete();

		// (3) Handle result
		System.out.println("Call delete() successful with the result: " + response.readEntity(String.class));
	}

	private static String getToken() {
		Form formData = new Form();
		formData.param("username", "admin");
		formData.param("password", "gpcoder");

		Client client = createJerseyRestClient();
		WebTarget target = client.target(AUTH_URL);
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.form(formData));
		return response.readEntity(String.class);
	}

	private static Client createJerseyRestClient() {
		ClientConfig clientConfig = new ClientConfig();

		// Config logging for client side
		clientConfig.register( //
				new LoggingFeature( //
						Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
						Level.INFO, //
						LoggingFeature.Verbosity.PAYLOAD_ANY, //
						10000));

		return ClientBuilder.newClient(clientConfig);
	}
}
