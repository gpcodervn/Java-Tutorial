package com.gpcoder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExample {

	public static void main(String[] args) throws SQLException {
		String sql = "{call find_user_by_name(?)}";
		try (
			Connection con = ConnectionUtils.openConnection();
			CallableStatement cstm = con.prepareCall(sql);
		) {
			// Set parameter values
			cstm.setString(1, "gpcoder1");
	        
	        // Executes the Procedure statement 
			try (ResultSet rs = cstm.executeQuery();) {
				while (rs.next()) {
					showUserInfo(rs);
				}
			}
		}
	}
	
	private static void showUserInfo(ResultSet rs) throws SQLException {
		System.out.println("Id: " + rs.getInt(1));
		System.out.println("UserName: " + rs.getString(2));
		System.out.println("Password: " + rs.getString("password"));
		System.out.println("CreatedDate: " + rs.getDate("createdDate"));
		System.out.println("---");
	}
}
