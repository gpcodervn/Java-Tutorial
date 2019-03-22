package com.gpcoder.mockito.injectmocks;

public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public String createUser(String email) {
		boolean result = userDao.createUser(email);
		if (result) {
			// Send an email verify ...
			// Show a success message to end user ...
			return "SUCCESS";
		}
		// Send an error message to end user ...
		return "FAILED";
	}
}
