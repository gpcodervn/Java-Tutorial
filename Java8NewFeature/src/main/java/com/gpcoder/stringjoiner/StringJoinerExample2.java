package com.gpcoder.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerExample2 {

	public static void main(String[] args) {
		StringJoiner stringJoinerWithPrefixSufix = new StringJoiner(",", "{", "}");
		stringJoinerWithPrefixSufix.add("1");
		stringJoinerWithPrefixSufix.add("2");
		stringJoinerWithPrefixSufix.add("3");
		System.out.println(stringJoinerWithPrefixSufix.toString()); // {1,2,3}
	}
}
