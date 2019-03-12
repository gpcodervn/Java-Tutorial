package com.gpcoder.junit.hamcrest.custom;

import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

class IsPositiveInteger extends TypeSafeMatcher<Integer> {

	@Factory
	public static Matcher<Integer> isAPositiveInteger() {
		return new IsPositiveInteger();
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("a positive integer");
	}

	@Override
	protected boolean matchesSafely(Integer integer) {
		return integer > 0;
	}
}

public class TypeSafeMatcherExample {

	@Test
	public void givenInteger_WhenAPositiveValue_ThenCorrect() {
		int num = 1;
		assertThat(num, IsPositiveInteger.isAPositiveInteger());
	}

	@Test
	public void givenInteger_WhenANegativeValue_ThenIncorrect() {
		int num = -1;
		assertThat(num, IsPositiveInteger.isAPositiveInteger());
	}
}
