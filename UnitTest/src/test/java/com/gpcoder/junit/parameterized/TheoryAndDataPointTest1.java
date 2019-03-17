package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertEquals;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryAndDataPointTest1 {

	@DataPoints
	public static int[][] data() {
		return new int[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } };
	}

	@Theory
	public void testFibonacci(final int[] inputs) {
		System.out.println(String.format("Testing with %d and %d", inputs[0], inputs[1]));
		assertEquals(inputs[1], Fibonacci.compute(inputs[0]));
	}
}
