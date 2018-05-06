package com.gpcoder.stream.terminal;

import java.util.Arrays;
import java.util.List;

public class CountStreamExample {

	// count() operation return the aggregate count for stream data
	public static void main(String[] args) {

		List<Integer> data = Arrays.asList(2, 3, 5, 4, 6);

		long count = data.stream().filter(num -> num % 3 == 0).count();
		System.out.println("Count = " + count);
	}
}
