package com.gpcoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementExample {

	public static void main(String[] args) throws SQLException {
		String sqlInsert = "INSERT INTO user(username, password, createdDAte) "
				+ " VALUE(?, ?, ?);";
		try (
			Connection con = ConnectionUtils.openConnection();
			PreparedStatement pstm = con.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
		) {
			// Set parameter values
			pstm.setString(1, "gpcoder-test-1");
	        pstm.setString(2, "pwd123");
	        pstm.setDate(3, new java.sql.Date(System.currentTimeMillis()));
	        
	        // Executes the SQL statement 
	        pstm.execute();
	        
	        // Get generated key
	        try (ResultSet rs = pstm.getGeneratedKeys();) {
        		int idValue = 0;
		        if (rs.next()) {
		            idValue = rs.getInt(1);
		        }
		        System.out.println("Auto-generated id: " + idValue);
        	}
		}
	}
}
