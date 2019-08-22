package com.gpcoder.api;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import com.gpcoder.model.Order;
import com.gpcoder.model.Role;

// http://localhost:8080/api/orders
@Path("/orders")
@RolesAllowed(Role.ROLE_ADMIN)
public class OrderService {

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		Order order = new Order();
		order.setId(1);
		order.setName("gpcoder");
		return Response.ok(order).build();
	}

	@POST
	public Response insert(Order order, @Context SecurityContext securityContext) {
		int newOrderId = 999;
		return Response.status(Status.CREATED).entity(newOrderId).build();
	}

	@PUT
	@Path("/{id}")
	public Response update(@PathParam("id") int id, Order order) {
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		return Response.status(Status.NO_CONTENT).build();
	}
}
