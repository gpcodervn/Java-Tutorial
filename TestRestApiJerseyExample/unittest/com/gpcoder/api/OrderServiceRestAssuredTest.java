package com.gpcoder.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gpcoder.model.Order;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderServiceRestAssuredTest {
	
	private static String BEARER_TOKEN = "";
	
	@BeforeClass
	public static void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        BEARER_TOKEN = getBearerToken();
	}
	
	public static String getBearerToken() {
		Response response = 
			given()
				.header("Content-Type", "application/x-www-form-urlencoded")
				.formParam("username", "gpcoder")
				.formParam("password", "gpcoder")
				.request()
			.when()
				.post("/api/auth")
			.then()
				.assertThat()
				.statusCode(Status.OK.getStatusCode())
				.extract()
				.response();
		return response.asString();
		
	}

	@Test
	public void testGetById_Way1() {
		given()
			.headers("Authorization", "Bearer " + BEARER_TOKEN)
			.accept(ContentType.JSON)
		.when()
			.get("/api/orders/1")
		.then()
			.statusCode(Status.OK.getStatusCode())
          	.contentType(ContentType.JSON)
          	.body("id", equalTo(1)) // Verify JSON Path
          	.body("name", equalTo("gpcoder"));
	}

	@Test
	public void testGetById_Way2() {
		Order order = 
			given()
				.headers("Authorization", "Bearer " + BEARER_TOKEN)
				.accept(ContentType.JSON)
			.when()
				.get("/api/orders/1")
			.then()
				.statusCode(Status.OK.getStatusCode())
	          	.contentType(ContentType.JSON)
	          	.extract().as(Order.class); // Use POJOs and Object Mapping
		
		Assert.assertEquals(1, order.getId().intValue());
		Assert.assertEquals("gpcoder", order.getName());
	}

	@Test
	public void testCreate() {
		Order order = new Order(1, "gpcoder");
		
		Integer newOrderId =
			given()
				.headers("Authorization", "Bearer " + BEARER_TOKEN)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(order)
			.when()
				.post("/api/orders")
			.then()
				.assertThat()
				.statusCode(Status.CREATED.getStatusCode())
				.extract().as(Integer.class);
		
		Assert.assertEquals(999, newOrderId.intValue());
	}

	@Test
	public void testUpdate() {
		Order order = new Order(1, "gpcoder edited");
		given()
			.headers("Authorization", "Bearer " + BEARER_TOKEN)
			.contentType(ContentType.JSON)
			.body(order)
		.when()
			.put("/api/orders/{id}/", order.getId())
		.then()
			.assertThat()
			.statusCode(Status.OK.getStatusCode());
	}

	@Test
	public void testDelete() {
		given()
			.headers("Authorization", "Bearer " + BEARER_TOKEN)
		.when()
			.delete("/api/orders/{id}/", 1)
		.then()
			.assertThat()
			.statusCode(Status.NO_CONTENT.getStatusCode());
	}
}
