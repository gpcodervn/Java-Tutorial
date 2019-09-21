package com.gpcoder.pool.thirdparties;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.gpcoder.constants.DbConfiguration;

public class DBCPDataSource {

	private static BasicDataSource ds = new BasicDataSource();

	static {
		ds.setDriverClassName(DbConfiguration.DB_DRIVER);
		ds.setUrl(DbConfiguration.CONNECTION_URL);
		ds.setUsername(DbConfiguration.USER_NAME);
		ds.setPassword(DbConfiguration.PASSWORD);
		ds.setMinIdle(DbConfiguration.DB_MIN_CONNECTIONS); // minimum number of idle connections in the pool
		ds.setInitialSize(DbConfiguration.DB_MIN_CONNECTIONS);
		ds.setMaxIdle(DbConfiguration.DB_MAX_CONNECTIONS); // maximum number of idle connections in the pool
		ds.setMaxOpenPreparedStatements(100);
	}

	private DBCPDataSource() {
		super();
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
