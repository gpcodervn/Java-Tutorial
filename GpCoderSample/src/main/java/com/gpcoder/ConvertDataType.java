package com.gpcoder;

import java.util.Arrays;

public class ConvertDataType {
	public static void main(String[] args) {
		byte[] b = {
			'g', 'p', 'c', 'o', 'd', 'e', 'r'
		};
		String str1 = new String(b);
		System.out.println(Arrays.toString(b));
		System.out.println(str1);
	}
}
