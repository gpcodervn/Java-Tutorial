package com.gpcoder.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gpcoder.helper.JwTokenHelper;
import com.gpcoder.model.User;
import com.gpcoder.service.UserService;

@Path("/auth")
public class AuthService {

	/**
	 * Authenticating a user with their username/ password and issuing a token
	 * 
	 * @param username
	 * @param password
	 * @return JSON Web Token (JWT)
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {

		// Authenticate the user using the credentials provided
		UserService userService = new UserService();
		User user = userService.getUser(username);
		if (user == null || !user.getPassword().equals(password)) {
			return Response.status(Response.Status.FORBIDDEN) // 403 Forbidden
					.entity("Wrong username or password") // the response entity
					.build();
		}

		// Issue a token for the user
		String token = JwTokenHelper.createJWT(user);

		// Return the token on the response
		return Response.ok(token).build();
	}
}