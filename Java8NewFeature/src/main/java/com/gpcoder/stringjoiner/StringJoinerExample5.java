package com.gpcoder.stringjoiner;

public class StringJoinerExample5 {

	public static final String DELIMITER = ", ";

	public static void main(String[] args) {
		final String DELIMITER = ", ";
		String[] arr = { "one", "two", "three" };
		int numOfElements = arr.length;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numOfElements; i++) {
			sb.append(arr[i]);
			if (i < numOfElements - 1) {
				sb.append(DELIMITER);
			}
		}
		System.out.println(sb.toString()); // one, two, three
	}
}
