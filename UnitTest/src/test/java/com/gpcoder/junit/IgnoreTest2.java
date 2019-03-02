package com.gpcoder.junit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("All test cases of this class will be ignored")
public class IgnoreTest2 {

	@Test
	public void test1() {
		String expected = "gpcoder.com";
		Assert.assertEquals(expected, "gpcoder.com");
	}

	@Test
	public void testTrue() {
		Assert.assertTrue(true);
	}

	@Test
	public void testFalse() {
		Assert.assertFalse(false);
	}
}
