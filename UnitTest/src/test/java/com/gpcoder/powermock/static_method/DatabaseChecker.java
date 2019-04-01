package com.gpcoder.powermock.static_method;

public class DatabaseChecker {
	
	public boolean isDatabaseConnected() {
		return DatabaseHelper.connect();
	}
	
	public void checkSql(String sql) {
		DatabaseHelper.executeSQL(sql);
	}
}
