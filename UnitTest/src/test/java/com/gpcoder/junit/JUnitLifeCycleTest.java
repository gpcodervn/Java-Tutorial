package com.gpcoder.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitLifeCycleTest {

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - runOnceBeforeClass");
	}

	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@AfterClass - runOnceAfterClass");
	}

	@Before
	public void runBeforeTestMethod() {
		System.out.println("@Before - runBeforeTestMethod");
	}

	@After
	public void runAfterTestMethod() {
		System.out.println("@After - runAfterTestMethod");
	}

	@Test
	public void test_method_1() {
		System.out.println("@Test - test_method_1");
	}

	@Test
	public void test_method_2() {
		System.out.println("@Test - test_method_2");
	}
}
