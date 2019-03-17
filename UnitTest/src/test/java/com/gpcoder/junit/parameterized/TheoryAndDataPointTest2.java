package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertEquals;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryAndDataPointTest2 {

	@DataPoint
	public static int[] input1 = new int[] { 0, 0 };
	
	@DataPoint
	public static int[] input2 = new int[] { 1, 1 };
	
	@DataPoint
	public static int[] input3 = new int[] { 2, 1 };
	
	@DataPoint
	public static int[] input4 = new int[] { 3, 2 };
	
	@DataPoint
	public static int[] input5 = new int[] { 4, 3 };
	
	@DataPoint
	public static int[] input6 = new int[] { 5, 5 };
	
	@DataPoint
	public static int[] input7 = new int[] { 6, 8 };

	@Theory
	public void testFibonacci(final int[] inputs) {
		System.out.println(String.format("Testing with %d and %d", inputs[0], inputs[1]));
		assertEquals(inputs[1], Fibonacci.compute(inputs[0]));
	}
}
