package com.gpcoder.pool.custom;

import java.sql.Connection;

public interface GPConnectionPool {

	Connection getConnection();

	boolean releaseConnection(Connection connection);
}