package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass4 {
	public static void main(String[] args) {
		// An array of int
		int[] i = new int[5];
		Arrays.fill(i, 10); // Assigns 10 to each element of the array
		System.out.println(Arrays.toString(i)); // Output : [10, 10, 10, 10, 10]

		// An array of double
		double[] d = { 12.5, 14.8, 45.9, 23.5 };
		Arrays.fill(d, 53.6); // Assigns 53.6 to each element of the array
		System.out.println(Arrays.toString(d)); // Output : [53.6, 53.6, 53.6, 53.6]

		// An array of boolean
		boolean[] bln = new boolean[5];
		Arrays.fill(bln, true); // Assigns true to each element of the array
		System.out.println(Arrays.toString(bln)); // Output : [true, true, true, true, true]

		// An array of char
		char[] c = new char[10];
		Arrays.fill(c, 'P'); // Assigns P to each element of the array
		System.out.println(Arrays.toString(c)); // Output : [P, P, P, P, P, P, P, P, P, P]

		// An array of String
		String[] str = { "Java", "Concepts", "basic java", "Arrays Class" };
		Arrays.fill(str, "value"); // Assigns value to each element of the array
		System.out.println(Arrays.toString(str)); // Output : [value, value, value, value]
	}
}
