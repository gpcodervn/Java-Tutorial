package com.gpcoder.junit.rule;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorRuleTest {

	/**
	 * The ErrorCollector rule allows execution of a test to continue after the
	 * first problem is found (for example, to collect _all_ the incorrect rows in a
	 * table, and report them all at once)
	 */
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void fails_first_assert_mismatch() {
		assertEquals(1, 2); // Failed and stop at first error
		assertEquals(2, 2); // Not running
		assertEquals(2, 3); // Not running
	}

	@Test
	public void fails_after_execution_1() {
		/**
		 * Adds a failure to the table if matcher does not match value.Execution
		 * continues, but the test will fail at the end if the match fails.
		 */
		collector.checkThat(5, is(8)); // First Error
		collector.checkThat(5, is(not(8))); // Passed
		collector.checkThat(5, is(equalTo(9))); // Second Error
	}

	@Test
	public void fails_after_execution_2() {
		/**
		 * Adds a Throwable to the table. Execution continues, but the test will fail at
		 * the end.
		 */
		collector.addError(new Throwable("first thing went wrong"));
		collector.checkThat(1, is(1));
		collector.checkThat(1, is(2));
	}
}