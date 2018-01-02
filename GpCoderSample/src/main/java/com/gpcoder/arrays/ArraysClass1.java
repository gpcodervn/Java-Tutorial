package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass1 {
	public static void main(String[] args) {
		// An array of byte
		byte[] b = { 10, 20, 30 };

		System.out.println(Arrays.toString(b)); // Output : [10, 20, 30]

		// An array of short
		short[] s = { 40, 50, 60, 70 };
		System.out.println(Arrays.toString(s)); // Output : [40, 50, 60, 70]

		// An array of int
		int[] i = { 12, 21, 42, 68 };
		System.out.println(Arrays.toString(i)); // Output : [12, 21, 42, 68]

		// An array of long
		long[] l = { 100, 110, 120, 130, 140, 150 };
		System.out.println(Arrays.toString(l)); // Output : [100, 110, 120, 130, 140, 150]

		// An array of double
		double[] d = { 12.5, 14.9, 87.4, 55.8 };
		System.out.println(Arrays.toString(d)); // Output : [12.5, 14.9, 87.4, 55.8]

		// An array of char
		char[] c = { 'A', 'B', 'C', 'D', 'E' };
		System.out.println(Arrays.toString(c)); // Output : [A, B, C, D, E]

		// An array of boolean
		boolean[] bln = { true, false, false, true };
		System.out.println(Arrays.toString(bln)); // Output : [true, false, false, true]

		// An array of String
		String[] str = { "welcome", "to", "gpcdoer" };
		System.out.println(Arrays.toString(str)); // Output : [welcome, to, gpcdoer]
	}
}
