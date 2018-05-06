package com.gpcoder.stream.intermediate;

import java.util.Arrays;
import java.util.List;

public class MapStreamExample {

	// map() operation helps map elements to the corresponding results
	public static void main(String[] args) {
		List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		data.stream() //
				.map(String::toUpperCase) // convert each element to upper case
				.forEach(System.out::println);
	}
}
