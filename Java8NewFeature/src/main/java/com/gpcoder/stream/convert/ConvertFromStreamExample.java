package com.gpcoder.stream.convert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertFromStreamExample {

	// Get Collections using stream.collect(Collectors.toList())
	public static void getCollectionUsingStreamCollection() {
		Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
		List<String> languages = stream.collect(Collectors.toList());
		System.out.println(languages);
	}

	// Get arrays using stream.toArray(EntryType[]::new)
	public static void getArrayUsingStreamToArray() {
		Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript");
		String[] languages = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(languages));
	}
}
