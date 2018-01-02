package com.gpcoder.recursion;

public class Fibonaci {
	public static long fibonaci(int n) {
		if (n < 3) { // Điều kiện thoát khỏi đệ quy
			return 1;
		}
		return fibonaci(n - 1) + fibonaci(n - 2); // gọi đệ quy
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("fibonaci(" + i + ") = " + fibonaci(i));
		}
	}

}
