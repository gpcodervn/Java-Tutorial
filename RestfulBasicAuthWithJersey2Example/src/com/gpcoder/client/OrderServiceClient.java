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
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;

public class OrderServiceClient {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/orders";

	public static void main(String[] args) {
		// (1) Create client config
		ClientConfig clientConfig = new ClientConfig();

		// Config logging for client side
		clientConfig.register( //
				new LoggingFeature( //
						Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
						Level.INFO, //
						LoggingFeature.Verbosity.PAYLOAD_ANY, //
						10000));

		// (2) Create basic authentication
		HttpAuthenticationFeature authDetails = HttpAuthenticationFeature.basic("admin", "gpcoder");

		// (3) Create jersey client with authentication
		Client client = ClientBuilder.newClient(clientConfig);
		client.register(authDetails);

		// (4) Call @DELETE API
		WebTarget target = client.target(API_URL).path("1");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		final Response response = invocationBuilder.delete();

		// (5) Handle result
		System.out.println("Call delete() successful with the result: " + response.readEntity(String.class));
	}

	private void getClient() {
		// Basic authentication mode
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("username", "password");

		// Basic authentication – non-prempitive mode
		feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("username", "password").build();

		// Digest mode
		feature = HttpAuthenticationFeature.digest("user", "superSecretPassword");

		// Universal mode
		feature = HttpAuthenticationFeature.universal("user", "superSecretPassword");

		// Building the feature in universal mode with different credentials for basic
		// and digest
		feature = HttpAuthenticationFeature.universalBuilder() //
				.credentialsForBasic("username1", "password1") // will be used for basic authentication only
				.credentials("username2", "password2") // having different credentials for different schemes
				.build();

		final Client client = ClientBuilder.newClient();
		client.register(feature);
	}
}
