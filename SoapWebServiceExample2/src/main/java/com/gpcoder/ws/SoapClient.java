package com.gpcoder.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient {

	public static void main(String[] args) throws MalformedURLException {
		// Create URL of .wsdl file
		URL wsdlURL = new URL(SoapPublisher.WS_URL + "?wsdl");

		// Create a QName using targetNamespace and name
		QName qname = new QName("http://ws.gpcoder.com/", "UserServiceImplService");

		// Creates a Service instance with the specified WSDL document location and
		// service qualified name
		Service service = Service.create(wsdlURL, qname);

		// We need to pass interface and model beans to client
		UserService userService = service.getPort(UserService.class);

		User user1 = new User();
		user1.setId(1);
		user1.setUsername("gpcoder.com");

		User user2 = new User();
		user2.setId(2);
		user2.setUsername("gpcoder.com");

		System.out.println("Insert User : " + userService.insert(user1));
		System.out.println("Insert User : " + userService.insert(user2));

		System.out.println("Get User : " + userService.get(user1.getId()));

		user1.setUsername("gpcoder edited");
		System.out.println("Update User : " + userService.update(user1));

		System.out.println("Get all Users : " + Arrays.asList(userService.getAll()));

		System.out.println("Delete User : " + userService.delete(user1.getId()));

	}
}
