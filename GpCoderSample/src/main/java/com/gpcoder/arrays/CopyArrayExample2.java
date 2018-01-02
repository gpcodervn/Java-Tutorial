package com.gpcoder.arrays;

public class CopyArrayExample2 {
	public static void main(String[] args) {
		int[] a = { 12, 21, 0, 5, 7 }; // Declaring and initializing an array of ints

		int[] b = new int[a.length]; // Declaring and instantiating another array of ints with same length

		// Copy array
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		// Now changing values of one array will not reflect in another array

		a[2] = 56; // Changing value of 3rd element in array 'a'

		System.out.println(b[2]); // value of 3rd element in array 'b' will not change = 0

		b[4] = 100; // Changing value of 5th element in array 'b'

		System.out.println(a[4]); // value of 5th element in array 'a' will not change = 7
	}
}
