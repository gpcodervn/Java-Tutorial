package com.gpcoder.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class CustomNotFoundWithWebApplicationException extends WebApplicationException {

	private static final long serialVersionUID = 3861196832088411918L;

	/**
	 * Create a HTTP 404 (Not Found) exception.
	 */
	public CustomNotFoundWithWebApplicationException() {
		super(Status.NOT_FOUND);
	}

	/**
	 * Create a HTTP 404 (Not Found) exception.
	 * 
	 * @param message the String that is the entity of the 404 response.
	 */
	public CustomNotFoundWithWebApplicationException(String message) {
		super(Response.status(Status.NOT_FOUND).entity(message).type("text/plain").build());
	}
}