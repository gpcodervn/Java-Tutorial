package com.gpcoder.recursion;

public class Combine {
	public static int combine(int n, int k) {
		if (k > n) {
			return 0;
		}
		if (k == 0 || k == n) {
			return 1;
		} else {
			return (combine(n - 1, k) + combine(n - 1, k - 1)); // Binary Recursion
		}
	}

	public static void main(String[] args) {
		System.out.println("combine(10, 2) = " + combine(10, 2)); // 45
	}

}
