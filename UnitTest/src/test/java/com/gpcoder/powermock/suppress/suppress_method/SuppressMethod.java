package com.gpcoder.powermock.suppress.suppress_method;

public class SuppressMethod {

	private final String username;

	public SuppressMethod(String username) {
		this.username = username;
	}

	public String getUsername() {
		checkPermission();
		return "admin@" + username;
	}

	private void checkPermission() {
		throw new UnsupportedOperationException("This function is unimplemented yet");
	}
}
