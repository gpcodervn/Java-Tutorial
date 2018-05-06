package com.gpcoder.stream.terminal;

import java.util.Arrays;
import java.util.List;

public class MatchStreamExample {

	// match() operation returns a boolean depending upon the condition applied on
	// stream data
	public static void main(String[] args) {
		List<String> data = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
		boolean result = data.stream().anyMatch((s) -> s.equalsIgnoreCase("Java"));
		System.out.println(result); // true
	}
}
