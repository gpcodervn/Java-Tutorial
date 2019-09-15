package com.gpcoder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {

	public static void main(String[] args) throws SQLException {
		try (Connection con = ConnectionUtils.openConnection();
				Statement st = con.createStatement();
				) {
			con.setAutoCommit(false); // 1. Disable individualtransaction
			try {
				// This user will be inserted
				st.executeUpdate("INSERT INTO user(username, password, createdDAte) "
						+ "VALUE('user-1', '123', now());");
				System.out.println("Inserted user-1 successfully");
				
				// This is an error sql. Cannot insert user
				st.executeUpdate("INSERT INTO user2(username, password, createdDAte) "
						+ "VALUE('user-2', '123', now());");
				System.out.println("Inserted user-2 successfully");
				
				con.commit(); // 2. commit data to database if all command are success
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();  // 2. roll-back data if one of command are failed
				System.out.println("Rollback data");
			}
		}

	}
}
