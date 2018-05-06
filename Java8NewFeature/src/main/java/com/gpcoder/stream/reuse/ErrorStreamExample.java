package com.gpcoder.stream.reuse;

import java.util.stream.Stream;

public class ErrorStreamExample {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript") //
				.filter(s -> s.startsWith("J"));

		stream.anyMatch(s -> true); // ok
		stream.noneMatch(s -> true); // exception
	}
}
