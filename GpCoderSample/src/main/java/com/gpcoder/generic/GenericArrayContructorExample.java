package com.gpcoder.generic;

public class GenericArrayContructorExample {
	public static void main(String[] args) {
		GenericArrayContructor<Integer> generic = new GenericArrayContructor<Integer>(Integer.class);
		Integer[] myArray = generic.getMyArray();
		myArray[0] = 1;
		myArray[2] = 0;
	}
}
