package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

class Checker2 {
	public static boolean isGreaterThan(int number1, int number2) {
		return number1 > number2;
	}
}

@RunWith(Theories.class)
public class TheoryAndDataPointTest5 {

	@Theory
	public void multiplyIsInverseOfDivideWithInlineDataPoints(@Between(first = 3, last = 5) int number1,
			@Between(first = 1, last = 2) int number2) {
		System.out.println(String.format("Testing with %d and %d", number1, number2));
		assertTrue(Checker2.isGreaterThan(number1, number2));
	}
}
