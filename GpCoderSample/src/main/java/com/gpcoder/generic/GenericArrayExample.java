package com.gpcoder.generic;

public class GenericArrayExample {
	public static void main(String[] args) {
		// Một mảng các String.
		String[] names = new String[] { "Tom", "Jerry" };

		GenericArray<String> gArray = new GenericArray<String>(names);

		String last = gArray.getLastElement();

		System.out.println("Last Element = " + last);
	}
}
