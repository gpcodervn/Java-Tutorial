package com.gpcoder.junit.listener;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

	@Test
	public void assertTrueTest() {
		Assert.assertTrue(true);
	}

	@Test
	public void assertFalseTest() {
		Assert.assertFalse(false);
	}

	@Test
	public void assertEqualsTest() {
		Assert.assertFalse("This test case is failed", true);
	}
}
