package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass3 {
	public static void main(String[] args) {
		// An array of int
		int[] i = { 24, 13, 45, 37, 84, 13, 28 };

		// Sorting the int array
		Arrays.sort(i);

		// Printing sorted array
		System.out.println(Arrays.toString(i)); // Output : [13, 13, 24, 28, 37, 45, 84]

		// Searching the value
		System.out.println(Arrays.binarySearch(i, 37)); // Output : 4
		System.out.println(Arrays.binarySearch(i, 13)); // Output : 1
		System.out.println(Arrays.binarySearch(i, 1));  // Output : -1
		System.out.println(Arrays.binarySearch(i, 55)); // Output : -7

		// An array of char
		char[] c = { 'X', 'n', 'F', 's', 'D', 'J', 'j', 'F' };

		// Sorting the char array
		Arrays.sort(c);

		// Printing Sorted array
		System.out.println(Arrays.toString(c)); // Output : [D, F, F, J, X, j, n, s]

		// Searching the character
		System.out.println(Arrays.binarySearch(c, 'F')); // Output : 1
		System.out.println(Arrays.binarySearch(c, 'J')); // Output : 3
		System.out.println(Arrays.binarySearch(c, 'H')); // Output : -4
		System.out.println(Arrays.binarySearch(c, 'Z')); // Output : -6

		// An array of String
		String[] str = { "First", "second", "Third", "second", "Four", "fifth" };

		// Sorting the String array
		Arrays.sort(str);

		// Printing Sorted array
		System.out.println(Arrays.toString(str)); // Output : [First, Four, Third, fifth, second, second]

		// Searching the string in the array
		System.out.println(Arrays.binarySearch(str, "Third"));  // Output : 2
		System.out.println(Arrays.binarySearch(str, "second")); // Output : 4
		System.out.println(Arrays.binarySearch(str, "One"));    // Output : -3
		System.out.println(Arrays.binarySearch(str, "sixth"));  // Output : -7
	}
}
