package com.gpcoder.stream.intermediate;

import java.util.stream.Stream;

public class FilterStreamExample {

	// filter() operation helps eliminate elements based on certain criteria
	public static void main(String[] args) {
		Stream.iterate(1, count -> count + 1) //
				.filter(number -> number % 3 == 0) //
				.limit(6) //
				.forEach(System.out::println);
	}

}
