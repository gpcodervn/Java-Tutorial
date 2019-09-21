package com.gpcoder.pool.thirdparties;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.gpcoder.constants.DbConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0DataSource {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	static {
		try {
			cpds.setDriverClass(DbConfiguration.DB_DRIVER);
			cpds.setJdbcUrl(DbConfiguration.CONNECTION_URL);
			cpds.setUser(DbConfiguration.USER_NAME);
			cpds.setPassword(DbConfiguration.PASSWORD);
			cpds.setMinPoolSize(DbConfiguration.DB_MIN_CONNECTIONS);
			cpds.setInitialPoolSize(DbConfiguration.DB_MIN_CONNECTIONS);
			cpds.setMaxPoolSize(DbConfiguration.DB_MAX_CONNECTIONS);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	private C3p0DataSource() {
		super();
	}

	public static Connection getConnection(String task) throws SQLException {
		System.out.println("Getting connection for task " + task);
		Connection conn =  cpds.getConnection();
		logPoolStatus(task);
		return conn;
	}

	public synchronized static void logPoolStatus(String task) throws SQLException {
		System.out.println("Received connection for task " + task);
		System.out.println("+ Num of Connections: " + cpds.getNumConnections());
		System.out.println("+ Num of Idle Connections: " + cpds.getNumIdleConnections());
		System.out.println("+ Num of Busy Connections: " + cpds.getNumBusyConnections());
	}
}