package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterizedMultiFieldTest {

	// The index of the parameter is 0
	// Default value is always "value=0"
	@Parameter(value = 0)
	public int number; // NOT private

	// The index of the parameter is 1
	@Parameter(value = 1)
	public int expected; // NOT private

	// The name attribute is optional, provide an unique name for test
	@Parameters(name = "{index}: Fibonacci({0}) = {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
	}

	@Test
	public void testFibonacci() {
		assertEquals(expected, Fibonacci.compute(number));
	}
}
