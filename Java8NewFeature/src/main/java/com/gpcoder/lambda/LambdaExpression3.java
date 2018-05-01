package com.gpcoder.lambda;

@FunctionalInterface
interface Addable {
	int add(int a, int b);
}

public class LambdaExpression3 {

	public static void main(String[] args) {

		// Multiple parameters with data type in lambda expression
		Addable ad1 = (int a, int b) -> (a + b);
		System.out.println(ad1.add(10, 20));

		// Multiple parameters in lambda expression
		Addable ad2 = (a, b) -> (a + b);
		System.out.println(ad2.add(10, 20));

		// Lambda expression without return keyword.
		Addable ad3 = (a, b) -> (a + b);
		System.out.println(ad3.add(10, 20));

		// Lambda expression with return keyword.
		Addable ad4 = (a, b) -> {
			return (a + b);
		};
		System.out.println(ad4.add(10, 20));

		// Lambda expression without return keyword.
		Addable ad5 = (a, b) -> (a + b);
		System.out.println(ad5.add(10, 20));

		// Lambda expression with multi-statement
		Addable ad6 = (a, b) -> {
			int sum = (a + b);
			return sum;
		};
		System.out.println(ad6.add(10, 20));
	}

}
