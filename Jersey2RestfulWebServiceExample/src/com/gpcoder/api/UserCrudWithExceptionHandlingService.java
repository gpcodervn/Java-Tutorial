package com.gpcoder.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gpcoder.exception.CustomNotFoundWithWebApplicationException;
import com.gpcoder.exception.RecordNotFoundException;
import com.gpcoder.model.User;

//URI:
//http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
//http://localhost:8080/RestfulWebServiceExample/rest/v2/users
@Path("/v2/users")
public class UserCrudWithExceptionHandlingService {

	@GET
	@Path("/download/{type}")
	public Response downloadFile(@PathParam("type") String fileType) {
		if (!fileType.equalsIgnoreCase("docx") && !fileType.equalsIgnoreCase("jpg")) {
			throw new WebApplicationException(Status.PRECONDITION_FAILED);
		}
		return Response.ok("File downloaded").build();
	}

	@GET
	@Path("/download-v2/{type}")
	public Response downloadFileV2(@PathParam("type") String fileType) {
		if (!fileType.equalsIgnoreCase("docx") && !fileType.equalsIgnoreCase("jpg")) {
			throw new CustomNotFoundWithWebApplicationException(
					"Our system is only supported for the following file type: docx, jpg");
		}
		return Response.ok("File downloaded").build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getUserById(@PathParam("id") int id) {
		if (id < 0) {
			throw new RecordNotFoundException("Cannot find user with the given id: " + id);
		}
		User user = new User(1, "gpcoder");
		return Response.ok(user).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public boolean deleteUserById(@PathParam("id") int id) {
		throw new UnsupportedOperationException("The delete action is not ready yet!");
	}
}
