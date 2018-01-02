package com.gpcoder.recursion;

public class Factorial {
	public static long factorial(int n) {
		if (n == 0) { // Điều kiện thoát khỏi đệ quy
			return 1; 
		}
		return n * factorial(n - 1); // gọi đệ quy
	}

	public static void main(String[] args) {
		System.out.println("Factorial of 5 is: " + factorial(5));
	}

}
