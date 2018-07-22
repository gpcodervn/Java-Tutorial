package com.gpcoder.stringjoiner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinerExample4 {

	public static void main(String[] args) {
		// joining with delimiter
		List<String> list = Arrays.asList("one", "two", "three");
		String collectorJoiningWithDelimiter = list.stream()
				.map(element -> element)
				.collect(Collectors.joining(", "));
		System.out.println(collectorJoiningWithDelimiter); // one, two, three
		
		// joining with prefix & suffix
		String collectorJoiningWithPrefixSuffix = list.stream()
				.map(element -> element)
				.collect(Collectors.joining(", ", "{", "}"));
		System.out.println(collectorJoiningWithPrefixSuffix); // {one, two, three}
	}
}
