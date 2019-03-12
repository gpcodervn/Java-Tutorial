package com.gpcoder.junit.hamcrest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Person implements Comparable<Person> {
	private String name;
	private int age;

	@Override
	public int compareTo(Person o) {
		if (this.age == o.getAge())
			return 0;
		if (this.age > o.getAge())
			return 1;
		else
			return -1;
	}
}

public class NumberMatcherTest {

	@Test
	public void givenADouble_whenCloseTo_thenCorrect() {
		double actual = 1.3;
		double operand = 1;
		double error = 0.5;

		assertThat(actual, closeTo(operand, error));
	}

	@Test
	public void givenADouble_whenNotCloseTo_thenCorrect() {
		double actual = 1.6;
		double operand = 1;
		double error = 0.5;

		assertThat(actual, not(closeTo(operand, error)));
	}

	@Test
	public void givenABigDecimal_whenCloseTo_thenCorrect() {
		BigDecimal actual = new BigDecimal("1.0003");
		BigDecimal operand = new BigDecimal("1");
		BigDecimal error = new BigDecimal("0.0005");

		assertThat(actual, is(closeTo(operand, error)));
	}

	@Test
	public void givenABigDecimal_whenNotCloseTo_thenCorrect() {
		BigDecimal actual = new BigDecimal("1.0006");
		BigDecimal operand = new BigDecimal("1");
		BigDecimal error = new BigDecimal("0.0005");

		assertThat(actual, is(not(closeTo(operand, error))));
	}

	@Test
	public void given5_whenComparesEqualTo5_thenCorrect() {
		Integer five = 5;

		assertThat(five, comparesEqualTo(five));
	}

	@Test
	public void given5_whenNotComparesEqualTo7_thenCorrect() {
		Integer seven = 7;
		Integer five = 5;

		assertThat(five, not(comparesEqualTo(seven)));
	}

	@Test
	public void given7_whenGreaterThan5_thenCorrect() {
		Integer seven = 7;
		Integer five = 5;

		assertThat(seven, is(greaterThan(five)));
	}

	@Test
	public void given7_whenGreaterThanOrEqualTo5_thenCorrect() {
		Integer seven = 7;
		Integer five = 5;

		assertThat(seven, is(greaterThanOrEqualTo(five)));
	}

	@Test
	public void given5_whenGreaterThanOrEqualTo5_thenCorrect() {
		Integer five = 5;

		assertThat(five, is(greaterThanOrEqualTo(five)));
	}

	@Test
	public void given3_whenLessThan5_thenCorrect() {
		Integer three = 3;
		Integer five = 5;

		assertThat(three, is(lessThan(five)));
	}

	@Test
	public void given3_whenLessThanOrEqualTo5_thenCorrect() {
		Integer three = 3;
		Integer five = 5;

		assertThat(three, is(lessThanOrEqualTo(five)));
	}

	@Test
	public void given5_whenLessThanOrEqualTo5_thenCorrect() {
		Integer five = 5;

		assertThat(five, is(lessThanOrEqualTo(five)));
	}

	@Test
	public void givenGpcoder_whenGreaterThanJavaGpcoder_thenCorrect() {
		String str1 = "Gpcoder";
		String str2 = "JavaGpcoder";

		assertThat(str1, is(greaterThan(str2)));
	}

	@Test
	public void givenJavaGpcoder_whenLessThanBenajmin_thenCorrect() {
		String str1 = "gpcoder";
		String str2 = "gpcoder.com";

		assertThat(str1, is(lessThan(str2)));
	}

	@Test
	public void givenToday_whenGreaterThanYesterday_thenCorrect() {
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);

		assertThat(today, is(greaterThan(yesterday)));
	}

	@Test
	public void givenToday_whenLessThanTomorrow_thenCorrect() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);

		assertThat(today, is(lessThan(tomorrow)));
	}

	@Test
	public void givenJavaGpcoder_whenOlderThanGpcoder_thenCorrect() {
		Person amanda = new Person("JavaGpcoder", 20);
		Person benjamin = new Person("Gpcoder", 18);

		assertThat(amanda, is(greaterThan(benjamin)));
	}

	@Test
	public void givenGpcoder_whenYoungerThanJavaGpcoder_thenCorrect() {
		Person amanda = new Person("JavaGpcoder", 20);
		Person benjamin = new Person("Gpcoder", 18);

		assertThat(benjamin, is(lessThan(amanda)));
	}
}
