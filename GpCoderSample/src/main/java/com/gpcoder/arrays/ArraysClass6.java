package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass6 {
	public static void main(String[] args) {
		// An array of int
		int[] i = { 1, 21, 15, 48, 79 };
		// Copying some part of array i into array i1
		int[] i1 = Arrays.copyOfRange(i, 2, 7);
		System.out.println(Arrays.toString(i1)); // Output : [15, 48, 79, 0, 0]

		// An array of double
		double[] d = { 12.5, 45.8, 56.2, 47.9, 23.6, 89.5 };
		// Copying some part of array d into array d1
		double[] d1 = Arrays.copyOfRange(d, 2, 5);
		System.out.println(Arrays.toString(d1)); // Output : [56.2, 47.9, 23.6]

		// An array of boolean
		boolean[] bln = { true, false, true, true, false };
		// Copying some part of array bln into array bln1
		boolean[] bln1 = Arrays.copyOfRange(bln, 1, 8);
		System.out.println(Arrays.toString(bln1)); // Output : [false, true, true, false, false, false, false]

		// An array of char
		char[] c = { 'X', 'B', 'Z', 'H', 'I', 'J' };
		// Copying some part of array c into array c1
		char[] c1 = Arrays.copyOfRange(c, 2, 4);
		System.out.println(Arrays.toString(c1)); // Output : [Z, H]

		// An array of String
		String[] str = { "java", "j2ee", "struts", "hibernate" };
		// Copying some part of array str into array str1
		String[] str1 = Arrays.copyOfRange(str, 4, 8);
		System.out.println(Arrays.toString(str1)); // Output : [null, null, null, null]
	}
}
