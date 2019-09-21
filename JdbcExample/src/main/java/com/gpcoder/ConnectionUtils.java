package com.gpcoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gpcoder.constants.DbConfiguration;

public class ConnectionUtils {
	
	private ConnectionUtils() {}

	public static Connection openConnection() throws SQLException {
		// 1. Load Driver
		// Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		// 2. Open connection
		return DriverManager.getConnection(DbConfiguration.CONNECTION_URL, 
				DbConfiguration.USER_NAME, DbConfiguration.PASSWORD);
	}
}
