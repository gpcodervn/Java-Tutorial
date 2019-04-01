package com.gpcoder.powermock.private_method;

public class PrivateConstructor {

	private String username;

	private PrivateConstructor() {
		this.username = "default value when no argument";
	}

	private PrivateConstructor(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
}
