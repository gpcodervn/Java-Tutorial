package com.gpcoder.stream.intermediate;

import java.util.Arrays;
import java.util.List;

public class SortedStreamExample {

	// sorted() operation helps sort elements based on certain criteria
	public static void main(String[] args) {
		List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		// sorted according to natural order
		data.stream() //
				.sorted() //
				.forEach(System.out::println);

		// sorted according to the provided Comparator
		data.stream() //
				.sorted((s1, s2) -> s1.length() - s2.length()) //
				.forEach(System.out::println);
	}
}
