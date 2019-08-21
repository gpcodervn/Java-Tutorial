package com.gpcoder.api;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.gpcoder.model.Order;

public class OrderServiceTest extends JerseyTest {

	@Override
	public Application configure() {
		return new ResourceConfig(OrderService.class);
	}

	@Test
	public void testGetById() {
		Response response = target("/orders/1").request().accept(MediaType.APPLICATION_JSON).get();
		assertEquals("Should return status 200", 200, response.getStatus());
		assertNotNull("Should return user object as json", response.getEntity());
		assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, 
				response.getHeaderString(HttpHeaders.CONTENT_TYPE));
		assertThat("Should return new order contains gpcoder string", 
				response.readEntity(String.class), containsString("gpcoder"));
	}

	@Test
	public void testCreate() {
		Order order = new Order(1, "gpcoder");
		Response response = target("/orders").request().post(Entity.entity(order, MediaType.APPLICATION_JSON));
		assertEquals("Should return status 201", 201, response.getStatus());
		assertNotNull("Should return new order id", response.readEntity(Integer.class));
	}

	@Test
	public void testUpdate() {
		Order order = new Order(1, "gpcoder edited");
		Response response = target("/orders/1").request().put(Entity.entity(order, MediaType.APPLICATION_JSON));
		assertEquals("Should return status 200", 200, response.getStatus());
	}

	@Test
	public void testDelete() {
		Response response = target("/orders/1").request().delete();
		assertEquals("Should return status 204", 204, response.getStatus());
	}
}
