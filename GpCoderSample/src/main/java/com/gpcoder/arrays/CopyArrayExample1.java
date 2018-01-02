package com.gpcoder.arrays;

public class CopyArrayExample1 {
	public static void main(String[] args) {

		int[] a = { 12, 21, 0, 5, 7 }; // Declaring and initializing an array of ints

		int[] b = a; // copying array 'a' to array 'b'

		// Printing elements of array 'b'
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

		a[2] = 56; // Changing value of 3rd element of array 'a'

		System.out.println(b[2]); // value of 3rd element of array 'b' also changes = 56

		b[4] = 100; // Changing value of 5th element of array 'b'

		System.out.println(a[4]); // value of 5th element of array 'a' also changes = 100
	}
}
