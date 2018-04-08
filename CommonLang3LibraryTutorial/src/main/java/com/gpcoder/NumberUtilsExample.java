package com.gpcoder;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtilsExample {

	public static void main(String[] args) {
		System.out.println(NumberUtils.min(4, 2, 6)); // 2
		System.out.println(NumberUtils.min(1.0, 1.6, 2.0, 0.8)); // 0.8
		System.out.println(NumberUtils.min(new long[] { 1, 4, 2, 6, 5, 3 })); // 2

		System.out.println(NumberUtils.max(4, 2, 6)); // 6
		System.out.println(NumberUtils.max(1.0, 1.6, 2.0, 0.8)); // 2.0
		System.out.println(NumberUtils.max(new long[] { 1, 4, 2, 6, 5, 3 })); // 6

		// NumberUtils.toInt(String str)
		System.out.println(NumberUtils.toInt(null)); // 0
		System.out.println(NumberUtils.toInt("")); // 0
		System.out.println(NumberUtils.toInt("123")); // 123

		// NumberUtils.toInt(String str, int defaultValue)
		System.out.println(NumberUtils.toInt(null, 1)); // 1
		System.out.println(NumberUtils.toInt("", 1)); // 1
		System.out.println(NumberUtils.toInt("123", 1)); // 123

		// NumberUtils.toDouble(String str)
		System.out.println(NumberUtils.toDouble(null)); // 0.0
		System.out.println(NumberUtils.toDouble("")); // 0.0
		System.out.println(NumberUtils.toDouble("3.14")); // 3.14

		// NumberUtils.toDouble(String str, double defaultValue)
		System.out.println(NumberUtils.toDouble(null, 1)); // 1.0
		System.out.println(NumberUtils.toDouble("", 1)); // 1.0
		System.out.println(NumberUtils.toDouble("3.14", 1)); // 3.14
	}

}
