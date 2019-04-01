package com.gpcoder.powermock.private_constructor;

public class UserService {
	
	private UserDao userDao;

	private UserService() {
		userDao = new UserDaoImpl();
	}
	
	public static UserService createInstance() {
		return new UserService();
	}
	
	public void insert() {
		userDao.insert();
	}
}
