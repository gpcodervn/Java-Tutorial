package com.gpcoder.method_reference;

@FunctionalInterface
interface ExecuteFunction {
	public int execute(int a, int b);
}

class MathUtils {
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}
}

public class DemoMethodReference1 {
	public static void main(String[] args) {
		int a = 10;
		int b = 7;

		int sum = doAction(a, b, MathUtils::sum);
		System.out.println(a + " + " + b + " = " + sum); // 10 + 7 = 17

		int minus = doAction(a, b, MathUtils::minus);
		System.out.println(a + " - " + b + " = " + minus); // 10 - 7 = 3
	}

	public static int doAction(int a, int b, ExecuteFunction func) {
		return func.execute(a, b);
	}
}
