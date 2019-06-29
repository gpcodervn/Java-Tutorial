package com.gpcoder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientExample {

	public static final String BASE_URL = "http://localhost:8080/RestfulWebServiceExample/rest";
	private static String token;

	public static void main(String[] args) throws IOException {
		token = getToken();
		System.out.println("token: " + token);

		createOrder();
		retrieveOrder();
		updateOrder();
		deleteOrder();
	}

	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/auth
	 */
	private static String getToken() throws IOException {
		// Create A URL Object
		URL url = new URL(BASE_URL + "/auth");

		// Open a Connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set the Request Content-Type Header Parameter
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

		// Set Response Format Type
		connection.setRequestProperty("Accept", "application/json");

		// Set the Request Method
		connection.setRequestMethod("POST");

		// Create the Request Body and Send post request
		String urlParameters = "username=gpcoder&password=gpcoder";
		sendRequest(connection, urlParameters);

		// Read the Response from Input Stream
		return getResponse(connection);
	}

	private static void sendRequest(HttpURLConnection connection, String data) throws IOException {
		// Ensure the Connection Will Be Used to Send Content
		connection.setDoOutput(true);

		// Create the Request Body and Send post request
		try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
			wr.writeBytes(data);
			wr.flush();
		}
	}

	private static String getResponse(HttpURLConnection connection) throws IOException {
		int responseCode = connection.getResponseCode();
		System.out.println("Response Code : " + responseCode);

		StringBuilder response = new StringBuilder();
		try (InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(is));) {
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
			}
		}
		return response.toString();
	}

	/**
	 * @POST http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void createOrder() throws IOException {
		// Create A URL Object
		URL url = new URL(BASE_URL + "/orders");

		// Open a Connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set Authorization header
		connection.setRequestProperty("Authorization", "Bearer " + token);

		// Set the Request Content-Type Header Parameter
		connection.setRequestProperty("Content-Type", "application/json");

		// Set the Request Method
		connection.setRequestMethod("POST");

		// Create the Request Body and Send post request
		String data = "{\"id\" : 1, \"name\": \"gpcoder\"}";
		sendRequest(connection, data);

		// Read the Response from Input Stream
		String response = getResponse(connection);
		System.out.println("createOrder: " + response);
	}

	/**
	 * @GET http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void retrieveOrder() throws IOException {
		// Create A URL Object
		URL url = new URL(BASE_URL + "/orders/1");

		// Open a Connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set Authorization header
		connection.setRequestProperty("Authorization", "Bearer " + token);

		// Set the Request Method
		connection.setRequestMethod("GET");

		// Read the Response from Input Stream
		String response = getResponse(connection);
		System.out.println("retrieveOrder: " + response);
	}

	/**
	 * @PUT http://localhost:8080/RestfulWebServiceExample/rest/orders
	 */
	private static void updateOrder() throws IOException {
		// Create A URL Object
		URL url = new URL(BASE_URL + "/orders");

		// Open a Connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set Authentication header
		connection.setRequestProperty("Authorization", "Bearer " + token);

		// Set the Request Content-Type Header Parameter
		connection.setRequestProperty("Content-Type", "application/json");

		// Set the Request Method
		connection.setRequestMethod("PUT");

		// Create the Request Body and Send post request
		String data = "{\"id\" : 1, \"name\": \"gpcoder\"}";
		sendRequest(connection, data);

		// Read the Response from Input Stream
		String response = getResponse(connection);
		System.out.println("updateOrder: " + response.toString());
	}

	/**
	 * @DELETE http://localhost:8080/RestfulWebServiceExample/rest/orders/1
	 */
	private static void deleteOrder() throws IOException {
		// Create A URL Object
		URL url = new URL(BASE_URL + "/orders/1");

		// Open a Connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set Authorization header
		connection.setRequestProperty("Authorization", "Bearer " + token);

		// Set the Request Method
		connection.setRequestMethod("DELETE");

		// Read the Response from Input Stream
		String response = getResponse(connection);
		System.out.println("deleteOrder: " + response);
	}
}
