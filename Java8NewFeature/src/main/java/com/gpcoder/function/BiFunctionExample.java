package com.gpcoder.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {

	public static void main(String[] args) {

		BiFunction<String, String, String> function1 = (s1, s2) -> s1 + s2;
		System.out.println(function1.apply("gpcoder", ".com")); // gpcoder.com

		BiFunction<Integer, Integer, Integer> function2 = (a, b) -> a + b;
		System.out.println(function2.apply(1, 2)); // 3

		BiFunction<Integer, Integer, Integer> times2 = (a, b) -> a + b;
		Function<Integer, Integer> squared = (n) -> n * n;

		BiFunction<Integer, Integer, Integer> andThen = times2.andThen(squared);
		System.out.println("Using andThen: " + andThen.apply(5, 2)); // 49
	}
}
