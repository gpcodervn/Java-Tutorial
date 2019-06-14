package com.gpcoder.client;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.model.User;

public class UserCrudJerseyRestClientExample {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/users";

	public static void main(String[] args) {
		System.out.println("Get User: " + getUser(1));

		System.out.println("Get Users: " + getUsers());

		Integer insertedId = createUser();
		System.out.println("Created User: " + insertedId);

		System.out.println("Updated User: " + updateUser(insertedId));
		System.out.println("After Updated User: " + getUser(insertedId));

		System.out.println("Updated User: " + deleteUser(insertedId));
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

	/**
	 * @GET /{id}
	 * 
	 *      Get one user with the given id
	 */
	private static User getUser(Integer id) {
		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL).path("" + id);
		return target.request(MediaType.APPLICATION_JSON_TYPE).get(User.class);
	}

	/**
	 * @GET
	 * 
	 * 		Get all users
	 */
	private static List<User> getUsers() {
		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL);
		GenericType<List<User>> entity = new GenericType<List<User>>() {
		};
		return target.request(MediaType.APPLICATION_JSON_TYPE).get(entity);
	}

	/**
	 * @PUT
	 * 
	 * 		create user
	 */
	private static Integer createUser() {
		User user = new User();
		user.setUsername("gpcoder client");
		String jsonUser = convertToJson(user);

		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL);
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.put(Entity.entity(jsonUser, MediaType.APPLICATION_JSON));
		return response.readEntity(Integer.class);
	}

	/**
	 * @POST
	 * 
	 * 		Update user
	 */
	private static Boolean updateUser(Integer id) {
		User user = getUser(id);
		user.setUsername(user.getUsername() + " edited");
		String jsonUser = convertToJson(user);

		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL);
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(jsonUser, MediaType.APPLICATION_JSON));
		return response.readEntity(Boolean.class);
	}

	/**
	 * @DELETE
	 * 
	 * 		Delete user
	 */
	private static Boolean deleteUser(Integer id) {
		Client client = createJerseyRestClient();
		WebTarget target = client.target(API_URL).path("" + id);
		Response response = target.request(MediaType.APPLICATION_JSON_TYPE).delete();
		return response.readEntity(Boolean.class);
	}

	private static String convertToJson(User user) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
