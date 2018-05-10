package com.gpcoder.predicate;

import java.util.function.Predicate;

public class PredicateExample2 {

	public static void main(String[] args) {

		Predicate<String> predicate = s -> {
			return s.equals("gpcoder");
		};

		// AND logical operation
		Predicate<String> predicateAnd = predicate.and(s -> s.length() == 11);
		System.out.println(predicateAnd.test("gpcoder.com")); // true

		// OR logical operation
		Predicate<String> predicateOr = predicate.or(s -> s.length() == 11);
		System.out.println(predicateOr.test("gpcoder.com")); // true

		// NEGATE logical operation
		Predicate<String> predicateNegate = predicate.negate();
		System.out.println(predicateNegate.test("gpcoder")); // false

		// tests if two arguments are equal
		Predicate<String> isEqual = Predicate.isEqual("gpcoder");
		System.out.println(isEqual.test("gpcoder")); // true
	}
}