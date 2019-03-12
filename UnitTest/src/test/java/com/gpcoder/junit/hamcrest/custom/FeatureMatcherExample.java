package com.gpcoder.junit.hamcrest.custom;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

class GetLength extends FeatureMatcher<String, Integer> {

	private GetLength(Matcher<? super Integer> subMatcher, String featureDescription, String featureName) {
		super(subMatcher, featureDescription, featureName);
	}

	@Factory
	public static GetLength length(Matcher<? super Integer> subMatcher) {
		return new GetLength(subMatcher, "a string of length that", "length");
	}

	@Override
	protected Integer featureValueOf(String actual) {
		return actual.length();
	}
	
}
public class FeatureMatcherExample {

	@Test
	public void givenString_WhenLengthIs7_ThenCorrect() {
	    assertThat("gpcoder", GetLength.length(is(7)));
	}

	@Test
	public void givenString_WhenLengthIs8_ThenIncorrect() {
	    assertThat("gpcoder", GetLength.length(is(8)));
	}
}
