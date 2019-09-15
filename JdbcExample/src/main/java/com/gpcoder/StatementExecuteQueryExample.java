package com.gpcoder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExecuteQueryExample {

	public static void main(String[] args) throws SQLException {
		String sqlSelect = "SELECT * FROM user";
		try (
				Connection con = ConnectionUtils.openConnection();
				Statement st = con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery(sqlSelect);
			) {

			while (rs.next()) {
				showUserInfo(rs);
			}

			System.out.println("\n=== Move to previous row ===");
			while (rs.previous()) {
				showUserInfo(rs);
			}
			
			System.out.println("\n=== Move to last row ===");
			rs.last();
			showUserInfo(rs);
			
			System.out.println("\n=== Move to first row ===");
			rs.first();
			showUserInfo(rs);
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
