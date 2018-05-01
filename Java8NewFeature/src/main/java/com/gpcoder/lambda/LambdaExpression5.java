package com.gpcoder.lambda;

public class LambdaExpression5 {

	public static void main(String[] args) {
		// Using an anonymous inner class
		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("Runnable 1");
			}
		};

		// Using Lambda Expression for Funcational Interface
		Runnable r2 = () -> System.out.println("Runnable 2");

		r1.run();
		r2.run();
	}
}
