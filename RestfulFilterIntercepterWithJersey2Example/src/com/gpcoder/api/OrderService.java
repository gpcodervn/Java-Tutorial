package com.gpcoder.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.gpcoder.model.Order;

// URI:
// http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
// http://localhost:8080/RestfulWebServiceExample/rest/orders
@Path("/orders")
public class OrderService {

	@GET
	@Path("/{id}")
	public Response get(@PathParam("id") int id) {
		System.out.println("OrderService#get()");
		return Response.ok("OrderService#get()").build();
	}

	@POST
	public Response insert(Order order) {
		System.out.println("OrderService#insert()");
		return Response.ok("OrderService#insert()").build();
	}

	@PUT
	public Response update(Order order) {
		System.out.println("OrderService#update()");
		return Response.ok("OrderService#update()").build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		System.out.println("OrderService#delete()");
		return Response.ok("OrderService#delete()").build();
	}
}
