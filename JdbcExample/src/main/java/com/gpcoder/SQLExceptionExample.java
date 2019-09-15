package com.gpcoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExceptionExample {

	private static final String hostName = "localhost";
	private static final String dbName = "jdbcdemo";
	private static final String userName = "root";
	private static final String password = "";
	private static final String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver2");
			
			Connection con = DriverManager.getConnection(connectionURL, userName, password);
			
			Statement st = con.createStatement();
			
			String sqlInsert = "INSERT INTO user(username, password, createdDate) "
					+ " VALUE('gpcoder', '123', now());";
			int numberRowsAffected = st.executeUpdate(sqlInsert);
			if (numberRowsAffected == 0) {
				System.out.println("insertion failed");
			} else {
				System.out.println("inserted successfully : " + numberRowsAffected);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
}
