package com.gpcoder.powermock.private_method;

public class PrivateMethod {

	private String username;

	public String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}
	
	public void resetUsername() {
		setUsername("NONAME");
	}
}
