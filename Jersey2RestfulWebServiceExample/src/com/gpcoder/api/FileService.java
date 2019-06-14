package com.gpcoder.api;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.gpcoder.model.FileUploadResponse;
import com.gpcoder.utils.FileUtils;

//URI:
//http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
//http://localhost:8080/RestfulWebServiceExample/rest/files
@Path("/files")
public class FileService {

	public static final String BASE_FOLDER = "D:/WorkSpace/GPCoder/Java-Tutorial/Jersey2RestfulWebServiceExample/data/";

	@GET
	@Path("/download/{type}")
	public Response downloadFile(@PathParam("type") String fileType) {

		String fileName = "test." + fileType;
		File file = new File(BASE_FOLDER + "download/" + fileName);

		/* Finding MIME type for explicitly setting MIME */
		String mimeType = new MimetypesFileTypeMap().getContentType(file);

		ResponseBuilder responseBuilder = Response.ok(file, mimeType);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		return responseBuilder.build();
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response uploadFile( //
			@FormDataParam("uploadFile") InputStream fileInputStream,
			@FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {

		String fileName = fileFormDataContentDisposition.getFileName();
		File uploadedFile = FileUtils.storeFile(fileInputStream, BASE_FOLDER, fileName);

		FileUploadResponse entity = new FileUploadResponse();
		entity.setFileName(uploadedFile.getName());
		entity.setFileSizeInByte(uploadedFile.length());
		entity.setCreatedDate(new Date());
		System.out.println("entity: " + entity);

		return Response.ok("File uploaded successfully at " + uploadedFile.getPath()).entity(entity).build();
	}
}
