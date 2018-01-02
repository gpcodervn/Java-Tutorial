package com.gpcoder.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysClass7 {
	public static void main(String[] args) {
		// An array of Integer
		Integer arr[] = { 4, 6, 1, 8, 3, 9, 7, 4, 2 };

		// Creates a wrapper list over arr[]
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list); // [4, 6, 1, 8, 3, 9, 7, 4, 2]

		// list.add(10); // UnsupportedOperationException
		// list.remove(0); // UnsupportedOperationException

		list.set(0, 5); // overwrite the elements
		System.out.println(list); // [5, 6, 1, 8, 3, 9, 7, 4, 2]
	}
}
