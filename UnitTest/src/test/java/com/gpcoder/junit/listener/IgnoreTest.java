package com.gpcoder.junit.listener;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class IgnoreTest {

	@Test
	@Ignore("This test case will be ignored")
	public void ignoreTest() {
		String expected = "gpcoder.com";
		Assert.assertEquals(expected, "gpcoder.com");
	}
}
