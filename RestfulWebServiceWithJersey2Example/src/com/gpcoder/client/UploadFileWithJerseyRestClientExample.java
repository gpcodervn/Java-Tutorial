package com.gpcoder.client;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.gpcoder.model.FileUploadResponse;

public class UploadFileWithJerseyRestClientExample {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/files/upload";

	public static final String BASE_FOLDER = "D:/WorkSpace/GPCoder/Java-Tutorial/Jersey2RestfulWebServiceExample/data/";

	public static void main(String[] args) throws IOException {

		File testFile = new File(BASE_FOLDER + "test.jpg");
		FileDataBodyPart filePart = new FileDataBodyPart("uploadFile", testFile);
		
		try (FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
			MultiPart multipart = formDataMultiPart.bodyPart(filePart);) {

			Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
			WebTarget target = client.target(API_URL);
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(multipart, multipart.getMediaType()));
	
			FileUploadResponse result = response.readEntity(FileUploadResponse.class);
			System.out.println("result: " + result);
		}
	}
}
