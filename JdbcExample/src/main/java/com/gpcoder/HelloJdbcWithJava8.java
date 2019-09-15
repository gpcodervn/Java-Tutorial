package com.gpcoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbcWithJava8 {
	private static final String hostName = "localhost";
	private static final String dbName = "jdbcdemo";
	private static final String userName = "root";
	private static final String password = "";
	// jdbc:mysql://hostname:port/dbname
	private static final String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load Driver
		// Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

		try (
			// 2. Open connection
			Connection con = DriverManager.getConnection(connectionURL, userName, password);
			// 3. Create Statement
			Statement st = con.createStatement();
		) {
			
			// 4. Execute query
			String sqlInsert = "INSERT INTO user(username, password, createdDAte) VALUE('gpcoder', '123', now());";
			int numberRowsAffected = st.executeUpdate(sqlInsert);
			if (numberRowsAffected == 0) {
				System.out.println("insertion failed");
			} else {
				System.out.println("inserted successfully : " + numberRowsAffected);
			}
		}

		// 5. Close connection: will be auto closed by try-with-resource
	}
}