package com.gpcoder.arrays;

import java.util.Arrays;

public class ArraysClass10 {
	public static void main(String[] args) {
		String[] s1 = { "java", "j2ee", "struts", "hibernate" };
		String[] s2 = { "hibernate", "struts", "j2ee", "java" };

		System.out.println(Arrays.equals(s1, s2)); // Output : false

		Arrays.sort(s1);
		Arrays.sort(s2);
		System.out.println(Arrays.equals(s1, s2)); // Output : true
	}
}
