package com.gpcoder.consumer;

import java.util.function.Consumer;

public class ConsumerExample1 {

	static void printValue(int val) {
		System.out.println(val);
	}

	public static void main(String[] args) {
		// Create Consumer interface with lambda expression
		Consumer<String> consumer1 = (name) -> System.out.println("Hello, " + name);
		// Calling Consumer method
		consumer1.accept("gpcoder"); // Hello, gpcoder

		// Create Consumer interface with method reference
		Consumer<Integer> consumer2 = ConsumerExample1::printValue;
		// Calling Consumer method
		consumer2.accept(12); // 12
	}
}