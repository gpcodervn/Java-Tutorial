package com.gpcoder.stream.intermediate;

import java.util.Arrays;
import java.util.List;

public class LimitStreamExample {

	// limit() Returns a stream consisting of the elements of this stream, truncated
	// to be no longer than maxSize in length.
	public static void main(String[] args) {
		List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		data.stream() //
				.skip(1) //
				.limit(3) //
				.forEach(System.out::print); // C#C++PHP
	}
}
