package com.gpcoder.ws.authentication;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class WelcomeClient {

	private static final String WS_URL = WelcomePublisher.WS_URL + "?wsdl";

	public static void main(String[] args) throws MalformedURLException {
		// Create URL of .wsdl file
		URL wsdlURL = new URL(WS_URL);

		// Create a QName using targetNamespace and name
		QName qname = new QName("http://authentication.ws.gpcoder.com/", "WelcomeServiceImplService");

		// Creates a Service instance with the specified WSDL document location and
		// service qualified name
		Service service = Service.create(wsdlURL, qname);

		// We need to pass interface and model beans to client
		WelcomeService userService = service.getPort(WelcomeService.class);

		// Prepare username & password
		Map<String, List<String>> headers = new HashMap<>();
		headers.put("username", Collections.singletonList("gpcoder"));
		headers.put("password", Collections.singletonList("jax-ws-by-gpcoder"));

		// Set request to header
		Map<String, Object> requestContext = ((BindingProvider) userService).getRequestContext();
		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

		// Send request and receive response
		System.out.println("Result: " + userService.getWelcomeMsg("gpcoder"));
	}
}
