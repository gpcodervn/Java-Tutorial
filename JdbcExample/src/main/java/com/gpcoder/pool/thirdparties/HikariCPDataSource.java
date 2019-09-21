package com.gpcoder.pool.thirdparties;

import java.sql.Connection;
import java.sql.SQLException;

import com.gpcoder.constants.DbConfiguration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDataSource {

	private static HikariConfig config = new HikariConfig();

	private static HikariDataSource ds;

	static {
		config.setDriverClassName(DbConfiguration.DB_DRIVER);
		config.setJdbcUrl(DbConfiguration.CONNECTION_URL);
		config.setUsername(DbConfiguration.USER_NAME);
		config.setPassword(DbConfiguration.PASSWORD);
		config.setMinimumIdle(DbConfiguration.DB_MIN_CONNECTIONS);
		config.setMaximumPoolSize(DbConfiguration.DB_MAX_CONNECTIONS);
		// Some additional properties
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds = new HikariDataSource(config);
	}

	private HikariCPDataSource() {
		super();
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
