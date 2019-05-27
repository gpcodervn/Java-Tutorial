package com.gpcoder.ws.client;

import java.util.Arrays;

import com.gpcoder.ws.User;
import com.gpcoder.ws.UserService;
import com.gpcoder.ws.UserServiceImplService;

/**
 * Run the following command to generate java classes file from .wsdl file
 * 
 * wsimport -s . http://localhost:8080/ws/users?wsdl
 */
public class SoapClient {

	public static void main(String[] args) {
		UserServiceImplService userServiceImplService = new UserServiceImplService();
		UserService userService = userServiceImplService.getUserServiceImplPort();
		
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
