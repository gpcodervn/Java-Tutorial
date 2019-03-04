package com.gpcoder.junit.parameterized;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterizedSingleFieldTest {

	// Default value is always "value=0"
	@Parameter
	public int number; // NOT private

	// The name attribute is optional, provide an unique name for test
	@Parameters
	public static Iterable<? extends Object> dataset() {
		return Arrays.asList(1, 2);
	}

	@Test
	public void testIsPositiveNumber() {
		Assert.assertEquals(true, number > 0);
	}
}
