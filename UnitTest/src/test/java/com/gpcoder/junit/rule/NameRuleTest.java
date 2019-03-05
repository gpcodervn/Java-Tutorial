package com.gpcoder.junit.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class NameRuleTest {
	@Rule
	public TestName name = new TestName();

	@Test
	public void test1() {
		assertEquals("test1", name.getMethodName());
	}

	@Test
	public void test2() {
		assertEquals("test2", name.getMethodName());
	}
}