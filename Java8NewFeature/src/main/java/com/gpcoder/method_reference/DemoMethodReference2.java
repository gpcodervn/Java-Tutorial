package com.gpcoder.method_reference;

@FunctionalInterface
interface ExecuteFunction2 {
	public int execute(int a, int b);
}

class MathUtils2 {
	public int sum(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}
}

public class DemoMethodReference2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 7;

		MathUtils2 obj = new MathUtils2();
		int sum = doAction(a, b, obj::sum);
		System.out.println(a + " + " + b + " = " + sum); // 10 + 7 = 17

		int minus = doAction(a, b, obj::minus);
		System.out.println(a + " - " + b + " = " + minus); // 10 - 7 = 3
	}

	public static int doAction(int a, int b, ExecuteFunction2 func) {
		return func.execute(a, b);
	}
}
