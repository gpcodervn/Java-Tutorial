package com.gpcoder.junit.rule.ExternalResource;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Test;

public class UserDaoTest {

	/**
	 * When we use @ClassRule, our rule instance should be static, 
	 * just like @BeforeClass and @AfterClass methods.
	 */
	@ClassRule
	public static DatabaseExternalResource db = new DatabaseExternalResource();

	@Test
	public void testInsert() {
		assertEquals(true, db.getConnection().insert());
	}

	@Test
	public void testUpdate() {
		assertEquals(true, db.getConnection().update());
	}
}
