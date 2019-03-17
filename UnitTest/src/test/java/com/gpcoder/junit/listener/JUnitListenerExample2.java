package com.gpcoder.junit.listener;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CustomBlockJUnit4ClassRunner.class)
public class JUnitListenerExample2 {

	@Test
	public void assertTrueTest() {
		Assert.assertTrue(true);
	}

	@Test
	public void assertFalseTest() {
		Assert.assertFalse(false);
	}

	@Test
	@Ignore("This test case will be ignored")
	public void ignoreTest() {
		String expected = "gpcoder.com";
		Assert.assertEquals(expected, "gpcoder.com");
	}
}
