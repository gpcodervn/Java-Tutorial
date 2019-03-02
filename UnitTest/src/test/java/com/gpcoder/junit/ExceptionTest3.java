package com.gpcoder.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gpcoder.junit.util.MathUtil;

public class ExceptionTest3 {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldTestExceptionMessage() throws Exception {
		// Keep this ordering: expect -> call the method which throw an exception
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Cannot divide by zero (0).");

		MathUtil.divide(1, 0);
	}
}
