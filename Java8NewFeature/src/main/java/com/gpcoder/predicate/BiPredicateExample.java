package com.gpcoder.predicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {

	public static void main(String[] args) {

		BiPredicate<Integer, String> condition = (i, s) -> i > 2 && s.startsWith("J");
		System.out.println(condition.test(5, "Java"));
		System.out.println(condition.test(2, "Javascript"));
		System.out.println(condition.test(1, "C#"));
	}
}
