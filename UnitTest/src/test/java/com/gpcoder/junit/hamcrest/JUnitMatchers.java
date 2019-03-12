package com.gpcoder.junit.hamcrest;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.IsNot.not;

import java.util.Calendar;
import java.util.Locale;

import org.hamcrest.core.IsSame;
import org.junit.Test;

class Today {
	/**
	 * Provide the day of the week of today's date.
	 * 
	 * @return Integer representing today's day of the week, corresponding to static
	 *         fields defined in Calendar class.
	 */
	public int getTodayDayOfWeek() {
		return Calendar.getInstance(Locale.US).get(Calendar.DAY_OF_WEEK);
	}
}

public class JUnitMatchers {

	// Is method checks two values are equal or not.
	// If they are equal it returns true!
	@Test
	public void isMatcherTest() {
		assertThat("gpcoder", is("gpcoder"));
		assertThat(true, is(true));
		assertThat(2019, is(2019));
	}

	// IsNot method checks two values are equal or not.
	// If they are not equal it returns true!
	@Test
	public void isnotMatcherTest() {
		assertThat("gpcoder.com", is(not("GPCODER")));
	}

	// IsEqual method checks given objects equality.
	@Test
	public void isEqualMatcherTest() {
		assertThat("gpcoder", equalTo("gpcoder"));
		assertThat("gpcoder", is(equalTo("gpcoder")));
	}

	// IsNot method creates a matcher that wraps an existing matcher, but inverts
	// the logic by which it will match.
	@Test
	public void isNotMatcherTest() {
		assertThat("gpcoder", not(equalTo("Java")));
		assertThat("gpcoder", is(not(equalTo("Java"))));
	}
	
	// EqualToIgnoringCase creates a matcher that matches if examined object is equals ignore case.
	@Test
    public void equalToIgnoringCaseTest() {
        assertThat("gpcoder", equalToIgnoringCase("GPCODER"));
    }
	
	// EqualToIgnoringCase creates a matcher that matches if examined object is equals ignore case.
	@Test
    public void equalToIgnoringWhiteSpaceTest() {
        assertThat("gpcoder", equalToIgnoringWhiteSpace("GP CODER"));
    }

	// IsNull creates a matcher that matches if examined object is null.
	@Test
	public void isNullMatcherTest() {
		assertThat(null, is(nullValue()));
		assertThat("gpcoder", is(notNullValue()));
	}

	// HasToString creates a matcher that matches if examined object is has To String.
	@Test
	public void hasToStringTest() {
		assertThat(4, hasToString("4"));
		assertThat(3.14, hasToString(containsString(".")));
	}

	// AllOf method creates a matcher that matches
	// if the examined object matches ALL of the specified matchers.
	@Test
	public void allOfMatcherTest() {
		assertThat("gpcoder.com", allOf(startsWith("gpcoder"), containsString("gp"), endsWith(".com")));
	}

	// AnyOf method creates a matcher that matches
	// if the examined object matches ANY of the specified matchers.
	@Test
	public void anyOfMatcherTest() {
		assertThat("gpcoder", anyOf(startsWith("gpcoder"), containsString(".com")));
		
		final Today instance = new Today();
		final int todayDayOfWeek = instance.getTodayDayOfWeek();
		assertThat(todayDayOfWeek,
				describedAs("Day of week is not in range",
						anyOf(is(Calendar.SUNDAY), 
								is(Calendar.MONDAY),
								is(Calendar.TUESDAY), 
								is(Calendar.WEDNESDAY),
								is(Calendar.THURSDAY), 
								is(Calendar.FRIDAY), 
								is(Calendar.SATURDAY))));
	}

	// IsInstanceOf method creates a matcher that matches when the examined object
	// is an instance of the specified type, as determined by calling the
	// Class.isInstance(Object) method on that type, passing the the examined object.
	@Test
	public void isInstanceOfMatcherTest() {
		assertThat(new JUnitMatchers(), instanceOf(JUnitMatchers.class));
	}

	// IsSame method creates a matcher that matches only when the
	// examined object is the same instance as the specified target object.
	@Test
	public void isSameMatcherTest() {
		String str1 = "gpcoder";
		String str2 = "gpcoder";

		assertThat(str1, IsSame.<String>sameInstance(str2));
	}

	// IsAnything method is a matcher that always returns true.
	@Test
	public void isAnythingMatcherTest() {
		assertThat("gpcoder", is(anything()));
		assertThat(1, is(anything()));
	}

	// describedAs method adds a description to a Matcher
	// When test is failed, it will show error like that:
	// java.lang.AssertionError: Expected: Sunday is not Saturday. but: was "Sunday"
	@Test
	public void describedAsMatcherTest() {
		assertThat("Sunday", describedAs("Sunday is not Saturday.", is("Saturday")));
	}
}