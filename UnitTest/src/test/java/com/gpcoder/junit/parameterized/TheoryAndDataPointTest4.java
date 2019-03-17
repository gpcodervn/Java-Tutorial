package com.gpcoder.junit.parameterized;

import static org.junit.Assert.assertTrue;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

class Checker {
	public static boolean isGreaterThan(int number1, int number2) {
		return number1 > number2;
	}
}

@RunWith(Theories.class)
public class TheoryAndDataPointTest4 {

	@Theory
	public void testAllNumber1GreaterThanAllNumber2(@TestedOn(ints = { 3, 4, 5 }) int number1,
			@TestedOn(ints = { 1, 2 }) int number2) {
		System.out.println(String.format("Testing with %d and %d", number1, number2));
		assertTrue(Checker.isGreaterThan(number1, number2));
	}
}
