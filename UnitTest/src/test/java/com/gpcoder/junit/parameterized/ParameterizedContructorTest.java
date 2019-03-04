package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ParameterizedContructorTest {

	private int number;
	private int expected;

	// Inject via constructor
	public ParameterizedContructorTest(int number, int expected) {
		this.number = number;
		this.expected = expected;
	}

	// The name attribute is optional, provide an unique name for test
    @Parameters(name = "{index}: Fibonacci({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
        	{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Test
    public void testFibonacci() {
        assertEquals(expected, Fibonacci.compute(number));
    }
}
