package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass5 {
	public static void main(String[] args) {
		// An array of int
		int[] i = { 1, 21, 15, 48, 79 };
		// Copying array i into array i1
		int[] i1 = Arrays.copyOf(i, 10);
		System.out.println(Arrays.toString(i1)); // Output : [1, 21, 15, 48, 79, 0, 0, 0, 0, 0]

		// An array of double
		double[] d = { 12.5, 45.8, 56.2, 47.9, 23.6, 89.5 };
		// Copying array d into array d1
		double[] d1 = Arrays.copyOf(d, 4);
		System.out.println(Arrays.toString(d1)); // Output : [12.5, 45.8, 56.2, 47.9]

		// An array of boolean
		boolean[] bln = { true, false, true, true, false };
		// Copying array bln into array bln1
		boolean[] bln1 = Arrays.copyOf(bln, 10);
		System.out.println(Arrays.toString(bln1)); // Output : [true, false, true, true, false, 
													// false, false, false, false, false]

		// An array of char
		char[] c = { 'X', 'B', 'Z', 'H', 'I', 'J' };
		// Copying array c into array c1
		char[] c1 = Arrays.copyOf(c, 5);
		System.out.println(Arrays.toString(c1)); // Output : [X, B, Z, H, I]

		// An array of String
		String[] str = { "java", "j2ee", "struts", "hibernate" };
		// Copying array str into array str1
		String[] str1 = Arrays.copyOf(str, 7);
		System.out.println(Arrays.toString(str1)); // [java, j2ee, struts, hibernate, null, null, null]
	}
}
