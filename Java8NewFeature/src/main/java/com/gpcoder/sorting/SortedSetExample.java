package com.gpcoder.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SortedSetExample {
	public static final List<Integer> NUMBERS = Arrays.asList( 5, 1, 2, 4, 3, 6, 7, 9, 8 );

	public static void main(String[] args) {
		// Original data
		Set<Integer> set1 = new LinkedHashSet<>(NUMBERS);
		
		// Convert Set to List
		List<Integer> list1 = new ArrayList<>(set1);
		
		// Sorting a List
		Collections.sort(list1);
		
		// Convert List to Set
		set1 = new LinkedHashSet<>(list1);
		System.out.println(set1);
		// => [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
