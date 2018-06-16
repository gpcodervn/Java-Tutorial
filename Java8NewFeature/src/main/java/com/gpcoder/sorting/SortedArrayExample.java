package com.gpcoder.sorting;

import java.util.Arrays;

public class SortedArrayExample {
	public static final int NUMBERS[] = { 5, 1, 2, 4, 3, 6, 7, 9, 8 };

	public static void main(String[] args) {
		// Sorting Complete Array
		int arr1[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
		Arrays.sort(arr1);
		System.out.println(Arrays.toString(arr1));
		// => [1, 2, 3, 4, 5, 6, 7, 8, 9]
		
		// Sorting Part of an Array
		int arr2[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
		Arrays.sort(arr2, 2, 5);
		System.out.println(Arrays.toString(arr2));
		// => [5, 1, 2, 3, 4, 6, 7, 9, 8]
		
		// Java 8 parallelSort
		int arr3[] = Arrays.copyOf(NUMBERS, NUMBERS.length);
		Arrays.parallelSort(arr3);
		System.out.println(Arrays.toString(arr3));
		// => [1, 2, 3, 4, 5, 6, 7, 8, 9]
	}
}
