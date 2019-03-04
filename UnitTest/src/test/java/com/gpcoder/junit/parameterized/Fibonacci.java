package com.gpcoder.junit.parameterized;

public class Fibonacci {

	public static int compute(int n) {
		if (n <= 1) {
			return n;
		}
		return compute(n - 1) + compute(n - 2);
	}
}
