package com.gpcoder.powermock.verify_static_method;

public class UserService {

	public String insert() {
		final String username = "gpcoder.com";
		UserUtils.validate(username);
		String uuid = UserUtils.generateUniqueId();
		UserUtils.validate(uuid);
		return username;
	}
}
