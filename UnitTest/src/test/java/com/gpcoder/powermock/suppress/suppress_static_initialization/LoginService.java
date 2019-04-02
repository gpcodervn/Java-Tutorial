package com.gpcoder.powermock.suppress.suppress_static_initialization;

public class LoginService {

	private static final GoogleService GOOGLE_SERVICE = new GoogleService();

	private final String message;

	public LoginService(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
