package com.gpcoder;

import java.io.IOException;

import com.gpcoder.helper.FeignClientCreator;
import com.gpcoder.model.User;
import com.gpcoder.service.UserService;

public class FeignClientExample {

	private static UserService userService;

	public static void main(String[] args) throws IOException {
		userService = FeignClientCreator.getService(UserService.class);

		createUser();
		retrieveUser();
		updateUser();
		retrieveUsers();
		deleteUser();
	}

	private static void createUser() throws IOException {
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("gpcoder.com");

		User user2 = new User();
		user2.setId(2);
		user2.setUsername("gpcoder.com");
		
		System.out.println("createUser1: " + userService.createUser(user1));
		System.out.println("createUser2: " + userService.createUser(user2));
	}

	private static void retrieveUser() throws IOException {
		System.out.println("retrieveUser: " + userService.getUser(1));
	}

	private static void updateUser() throws IOException {
		User user1 = new User();
		user1.setId(1);
		user1.setUsername("gpcoder.com edited");
		System.out.println("updateUser: " + userService.updateUser(user1));
	}

	private static void deleteUser() throws IOException {
		System.out.println("deleteUser: " + userService.deleteUser(1));
	}

	private static void retrieveUsers() {
		System.out.println("retrieveUsers: " + userService.getUsers(1, 2));
	}
}
