package com.gpcoder.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

	@Test
	public void testAssertEquals() {
		assertEquals("failure - strings are not equal", "text", "text");
	}

	@Test
	public void testAssertArrayEquals() {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
		assertArrayEquals("failure - two arrays not same", arr1, arr2);
	}

	@Test
	public void testAssertTrue() {
		assertTrue("failure - should be true", true);
	}

	@Test
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNull() {
		assertNull("should be null", null);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull("should not be null", new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	public void testFail() throws Exception {
		Assert.fail("Make fails a test");
	}
}
