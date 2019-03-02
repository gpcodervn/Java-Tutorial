package com.gpcoder.junit;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FixMethodOrderTest {

	@Test
	public void test_11() {
		Assert.assertTrue(true);
	}

	@Test
	public void test_1() {
		Assert.assertTrue(true);
	}

	@Test
	public void test_10() {
		Assert.assertTrue(true);
	}

	@Test
	public void test_2() {
		Assert.assertTrue(true);
	}
}
