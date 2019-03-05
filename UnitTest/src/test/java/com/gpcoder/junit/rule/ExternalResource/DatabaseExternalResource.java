package com.gpcoder.junit.rule.ExternalResource;

import org.junit.rules.ExternalResource;

/**
 * A base class for Rules (like TemporaryFolder) that set up an external
 * resource before a test (a file, socket, server, database connection, etc.),
 * and guarantee to tear it down afterward
 */
public class DatabaseExternalResource extends ExternalResource {

	private static final DatabaseConnection connection = DatabaseConnection.getConnection();

	@Override
	protected void before() throws Throwable {
		connection.open();
	}

	@Override
	protected void after() {
		connection.close();
	}

	public DatabaseConnection getConnection() {
		return connection;
	}
}