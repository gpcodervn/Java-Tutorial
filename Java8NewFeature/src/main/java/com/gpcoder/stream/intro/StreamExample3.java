package com.gpcoder.stream.intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample3 {

	public static void main(String[] args) {
		// list 1
		List<String> javaCore = Arrays.asList("OOP", "Exception", "Multi-Thread");

		// list 2
		List<String> spring = Arrays.asList("Spring Boot", "Spring MVC", "Spring Data", "Spring Security");

		// creating two streams from the two lists and concatenating them into one
		Stream<String> opstream = Stream.concat(javaCore.stream(), spring.stream());

		// displaying the elements of the concatenated stream
		opstream.forEach(str -> System.out.print(str + ", "));
	}

}
