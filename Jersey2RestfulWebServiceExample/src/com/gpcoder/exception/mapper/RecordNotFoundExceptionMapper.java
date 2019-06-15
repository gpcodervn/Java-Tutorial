package com.gpcoder.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.gpcoder.exception.RecordNotFoundException;
import com.gpcoder.model.ErrorResponse;

@Provider
public class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException> {

	@Override
	public Response toResponse(RecordNotFoundException ex) {
		ErrorResponse response = new ErrorResponse();
		response.setStatus(Status.NOT_FOUND.getStatusCode()); // 404, "Not Found"
		response.setErrorMessage(ex.getMessage());

		return Response.status(response.getStatus())
				.entity(response)
				.type(MediaType.APPLICATION_JSON) // "application/json"
				.build();
	}
}