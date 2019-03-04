package com.gpcoder.junit.categories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassA {

	@Category(PerformanceTests.class)
	@Test
	public void test_A1() {
		Assert.assertTrue(true);
	}

	@Category({ PerformanceTests.class, RegressionTests.class })
	@Test
	public void test_A2() {
		Assert.assertTrue(true);
	}

	@Test
	public void test_A3() {
		Assert.assertTrue(true);
	}
}
