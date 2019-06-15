package com.gpcoder.exception.mapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		return Response.status(getStatusType(ex)) 
				.entity(ex.getMessage())
				.type(MediaType.TEXT_PLAIN) // "text/plain"
				.build();
	}
	
	private Response.StatusType getStatusType(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return((WebApplicationException)ex).getResponse().getStatusInfo();
        } else {
        	// 500, "Internal Server Error"
            return Response.Status.INTERNAL_SERVER_ERROR;
        }
    }
}