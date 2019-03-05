package com.gpcoder.junit.rule;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionRuleTest {

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void throwsNothing() {
		assertTrue(true);
	}

	@Test
	public void testThrowsNullPointerExceptionWithMessage() {
		// Verify that your code throws an exception that is an instance of specific type. 
		thrown.expect(NullPointerException.class);
		
		// Verify that your code throws an exception whose message contains a specific text.
		thrown.expectMessage("The given value cannot be null");
		
		// Do something to throw an NullPointerException
		throw new NullPointerException("The given value cannot be null");
	}
}
