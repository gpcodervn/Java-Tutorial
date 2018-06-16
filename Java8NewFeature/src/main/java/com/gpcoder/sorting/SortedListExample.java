package com.gpcoder.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedListExample {
	public static final List<Integer> NUMBERS = Arrays.asList( 5, 1, 2, 4, 3, 6, 7, 9, 8 );

	public static void main(String[] args) {
		// Sorting a List
		List<Integer> list1 = new ArrayList<>(NUMBERS);
		Collections.sort(list1);
		System.out.println(list1);
		// => [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
