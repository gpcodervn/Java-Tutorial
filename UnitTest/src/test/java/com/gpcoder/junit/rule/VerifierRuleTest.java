package com.gpcoder.junit.rule;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

public class VerifierRuleTest {

	private List<String> errorLog = new ArrayList<String>();

	/**
	 * Verifier is a base class for Rules like ErrorCollector, which can turn
	 * otherwise passing test methods into failing tests if a verification check is
	 * failed
	 */
	@Rule
	public Verifier verifier = new Verifier() {
		// After each method perform this check
		@Override
		public void verify() {
			assertTrue("Error Log is not Empty!", errorLog.isEmpty());
		}
	};

	@Test
	public void test1() {
		// Do something with an error and write to log
		errorLog.add("There is an error!");
	}

	@Test
	public void test2() {
		// Do something with an error and write to log
		errorLog.add("There is an error!");
	}

	@Test
	public void test3() {
		// Success
	}
}
