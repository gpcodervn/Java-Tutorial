package com.gpcoder.stringjoiner;

import java.util.Arrays;
import java.util.List;

public class StringJoinerExample3 {

	public static void main(String[] args) {
		String strWithJoiner = String.join(", ", "one", "two", "three");
		System.out.println(strWithJoiner); // one, two, three

		List<String> list = Arrays.asList("one", "two", "three");
		strWithJoiner = String.join(", ", list); // one, two, three
	}
}
