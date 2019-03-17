package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoryAndDataPointTest3 {

	@DataPoints("data1")
	public static int[][] dataPoints = new int[][] { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } };

	@DataPoints("data2")
	public static int[][] data() {
		return new int[][] { { 0, 999 }};
	}

	@Theory
	public void givenNumber_WhenValidValue_ThenEquals(@FromDataPoints("data1") final int[] inputs) {
		System.out.println(String.format("Testing with %d and %d", inputs[0], inputs[1]));
		assertEquals(inputs[1], Fibonacci.compute(inputs[0]));
	}

	@Theory
	public void givenNumber_WhenInvalidValue_ThenNotEquals(@FromDataPoints("data2") final int[] inputs) {
		System.out.println(String.format("Testing with %d and %d", inputs[0], inputs[1]));
		assertNotEquals(inputs[1], Fibonacci.compute(inputs[0]));
	}
}
