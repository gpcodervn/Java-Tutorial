package com.gpcoder;

public class IntegerCompare {

	public static void main(String[] args) {
		Integer i1 = 127; // Integer i1 = Integer.valueOf(i);
		Integer i2 = 127;

		Integer i3 = 128;
		Integer i4 = 128;

		Integer i5 = new Integer(127);
		Integer i6 = new Integer(127);

		int i7 = 127;

		System.out.println(i1 == i2); // = true
		System.out.println(i3 == i4); // = false
		System.out.println(i5 == i6); // = false
		System.out.println(i1 == i5); // = false
		System.out.println(i1 == i7); // = true
	}

}
