package com.gpcoder.junit.hamcrest.custom;

import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;

class IsEven extends TypeSafeDiagnosingMatcher<Integer> {

	@Factory
	public static IsEven isEven() {
		return new IsEven();
	}

	@Override
	protected boolean matchesSafely(Integer integer, Description description) {
		description.appendText("was ").appendValue(integer).appendText(", which is an Odd number");
		return integer % 2 == 0;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("An Even number");
	}
}

public class TypeSafeDiagnosingMatcherExample {

	@Test
	public void givenInteger_WhenEvenValue_ThenCorrect() throws Exception {
		assertThat(4, IsEven.isEven());
	}

	@Test
	public void givenInteger_WhenOddValue_ThenIncorrect() throws Exception {
		assertThat(5, IsEven.isEven());
	}
}
