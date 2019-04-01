package com.gpcoder.powermock.static_method;

public class DatabaseHelper {

	private DatabaseHelper() {
		throw new UnsupportedOperationException("Cannot call directly");
	}

	public static boolean connect() {
		throw new RuntimeException("Cannot connect to database");
	}
	
	public static void executeSQL(String sql) {
		throw new UnsupportedOperationException("This function is unimplemented yet");
	}
}
