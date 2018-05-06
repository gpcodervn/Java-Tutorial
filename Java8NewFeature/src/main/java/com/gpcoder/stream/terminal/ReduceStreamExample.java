package com.gpcoder.stream.terminal;

import java.util.stream.IntStream;

public class ReduceStreamExample {

	// reduce() operation combines the stream elements into one using a
	// BinaryOperator
	public static void main(String[] args) {

		int result = IntStream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
		System.out.println(result); // 10
	}
}
