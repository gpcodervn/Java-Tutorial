package com.gpcoder.powermock.private_constructor;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		throw new UnsupportedOperationException("Cannot connect database");
	}

	@Override
	public void insert() {
		throw new UnsupportedOperationException("This function is unimplemented yet");
	}
}
