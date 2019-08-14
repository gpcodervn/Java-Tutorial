package com.gpcoder.api;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.gpcoder.model.Order;
import com.gpcoder.model.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

// URI:
// http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
// http://localhost:8080/api/orders
@Path("/orders")
@PermitAll
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
@Tag(name = "Order service", 
	description = "CRUD operations for order service. User must be authorized with some resources.")
public class OrderService {

	@GET
	@Path("/{id}")
	@Operation(summary = "Get order by id", description = "This action published for everyone")
	@ApiResponse(responseCode = "200", description = "Get order by id")
	public Response get(@PathParam("id") int id) {
		System.out.println("OrderService->get()");
		return Response.ok("OrderService->get()").build();
	}

	@Operation(
		summary = "Insert an order", 
		responses = {
	         @ApiResponse(description = "Inserted an order based on the given information", 
	        		 content = @Content(mediaType = "application/json", 
	        		 schema = @Schema(implementation = String.class))),
	         @ApiResponse(responseCode = "200", description = "success"),
	         @ApiResponse(responseCode = "401", description = "User cannot access this resource."),
	         @ApiResponse(responseCode = "403", description = "User not authorized."),
	         @ApiResponse(responseCode = "500", description = "Internal Server Error.") 
         })
	@POST
	@RolesAllowed(Role.ROLE_CUSTOMER)
	public Response insert(Order order, @Context SecurityContext securityContext) {
		System.out.println("User: " + securityContext.getUserPrincipal().getName());
		System.out.println("OrderService->insert()");
		return Response.ok("OrderService->insert()").build();
	}

	@PUT
	@RolesAllowed({ Role.ROLE_ADMIN, Role.ROLE_CUSTOMER })
	@Operation(summary = "Update order", description = "Admin and Customer can do this action")
	public Response update(Order order) {
		System.out.println("OrderService->update()");
		return Response.ok("OrderService->update()").build();
	}

	@DELETE
	@Path("/{id}")
	@RolesAllowed(Role.ROLE_ADMIN)
	@Operation(summary = "Delete order by id", description = "Only Admin can do this action")
	public Response delete(@PathParam("id") int id) {
		System.out.println("OrderService->delete()");
		return Response.ok("OrderService->delete()").build();
	}
}
