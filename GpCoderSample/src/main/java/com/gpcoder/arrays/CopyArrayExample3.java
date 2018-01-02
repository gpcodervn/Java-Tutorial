package com.gpcoder.arrays;

import java.util.Arrays;

public class CopyArrayExample3 {
	public static void main(String[] args) {
		int[] a = { 12, 21, 0, 5, 7 }; // Declaring and initializing an array of ints

		// creating a copy of array 'a' using copyOf() method of java.util.Arrays class
		int[] b = Arrays.copyOf(a, a.length);

		// Printing elements of array 'b'
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

		// Now changing values of one array will not reflect in other array

		a[2] = 56; // Changing value of 3rd element in array 'a'

		System.out.println(b[2]); // value of 3rd element in array 'b' will not change = 0

		b[4] = 100; // Changing value of 5th element in array 'b'

		System.out.println(a[4]); // value of 5th element in array 'a' will not change = 7
	}
}
