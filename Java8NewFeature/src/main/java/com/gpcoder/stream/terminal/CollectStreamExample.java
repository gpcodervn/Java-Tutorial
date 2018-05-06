package com.gpcoder.stream.terminal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectStreamExample {

	// collect() operation helps to collect the stream result in a collection like
	// list
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
		List<String> languages = stream.collect(Collectors.toList());
		System.out.println(languages);
	}
}
