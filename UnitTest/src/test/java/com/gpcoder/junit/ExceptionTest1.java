package com.gpcoder.junit;

import org.junit.Test;

import com.gpcoder.junit.util.MathUtil;

public class ExceptionTest1 {

	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZero() throws Exception {
		MathUtil.divide(1, 0);
	}
}
