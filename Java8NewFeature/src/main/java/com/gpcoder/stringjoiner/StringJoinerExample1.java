package com.gpcoder.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerExample1 {

	public static void main(String[] args) {
		StringJoiner stringJoiner = new StringJoiner(", ");
		stringJoiner.add("one");
		stringJoiner.add("two");
		stringJoiner.add("three");
		System.out.println(stringJoiner.toString()); // one, two, three
	}
}
