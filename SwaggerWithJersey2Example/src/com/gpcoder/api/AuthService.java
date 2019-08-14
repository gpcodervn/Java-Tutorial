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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/auth")
@Tag(name = "Authentication services", 
	description = "Authenticating a user and issuing a JSON Web Token (JWT)")
public class AuthService {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Operation(summary = "Authenticating a user", 
		description = "Authenticating a user with their username/ password and issuing a JSON Web Token (JWT)",
		responses = {
		         @ApiResponse(description = "Authenticated user based on the given information", 
		        		 content = @Content(mediaType = "application/json", 
		        		 schema = @Schema(implementation = String.class))),
		         @ApiResponse(responseCode = "200", description = "success"),
		         @ApiResponse(responseCode = "403", description = "Wrong username or password."),
		         @ApiResponse(responseCode = "500", description = "Internal Server Error.") 
	         })
	public Response authenticateUser(
			@Parameter(description = "The user name for login. Some test account: admin, customer, gpcoder", required = true)
			@FormParam("username") String username, 
			@Parameter(description = "The password for login", required = true)
			@FormParam("password") String password) {

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