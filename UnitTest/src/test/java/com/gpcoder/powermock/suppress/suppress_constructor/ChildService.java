package com.gpcoder.powermock.suppress.suppress_constructor;

public class ChildService extends BaseService {

	private final String message;

	public ChildService(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
