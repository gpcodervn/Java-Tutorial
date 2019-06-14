package com.gpcoder.client;

import java.io.File;
import java.io.InputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.gpcoder.utils.FileUtils;

public class DownloadFileWithJerseyRestClientExample {

	public static final String API_URL = "http://localhost:8080/RestfulWebServiceExample/rest/files/download/";

	public static final String BASE_FOLDER = "D:/WorkSpace/GPCoder/Java-Tutorial/Jersey2RestfulWebServiceExample/data/";

	public static void main(String[] args) {

		Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
		WebTarget target = client.target(API_URL + "docx");
		Response resp = target.request().get();

		if (resp.getStatus() == Response.Status.OK.getStatusCode()) {
			InputStream is = resp.readEntity(InputStream.class);
			File uploadedFile = FileUtils.storeFile(is, BASE_FOLDER, "test-download.docx");
			System.out.println("uploadedFile: " + uploadedFile.getAbsolutePath());
		} else {
			System.out.println("Http Call failed. The response code is" + resp.getStatus() + //
					". Error reported is" + resp.getStatusInfo());
		}
	}
}
