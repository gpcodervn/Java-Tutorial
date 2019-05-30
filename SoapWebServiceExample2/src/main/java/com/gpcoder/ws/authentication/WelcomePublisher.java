package com.gpcoder.ws.authentication;

import javax.xml.ws.Endpoint;

public class WelcomePublisher {
	
	public static final String WS_URL = "http://localhost:8080/ws/welcome";

	public static void main(String[] args) {
		Endpoint.publish(WS_URL, new WelcomeServiceImpl());
		System.out.println("Server is published!");
	}
}
