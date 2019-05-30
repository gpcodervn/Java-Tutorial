package com.gpcoder.ws.document;

import javax.xml.ws.Endpoint;

public class DocumentPublisher {

	public static final String WS_URL = "http://localhost:8080/ws/document";

	public static void main(String[] args) {
		Endpoint.publish(WS_URL, new DocumentServiceImpl());
		System.out.println("Server is published!");
	}
}