package com.gpcoder.function;

import java.util.function.Function;

public class FunctionExample4 {

	public static void main(String[] args) {

		Function<Integer, Integer> times2 = n -> n * 2;
		Function<Integer, Integer> squared = n -> n * n;

		Function<Integer, Integer> andThen = times2.andThen(squared);
		System.out.println("Using andThen: " + andThen.apply(5)); // 100

		Function<Integer, Integer> compose = times2.compose(squared);
		System.out.println("Using compose: " + compose.apply(5)); // 50
	}
}
