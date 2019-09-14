package com.gpcoder.designpatterns.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LamdaChainOfResponsibilityExample {

	public static void main(String[] args) {

		UnaryOperator<String> filter1 = (str) -> {
			System.out.println("Filter1: " + str);
			return str + "->Filter1";
		};

		UnaryOperator<String> filter2 = (str) -> {
			System.out.println("Filter2: " + str);
			return str + "->Filter2";
		};

		UnaryOperator<String> filter3 = (str) -> {
			System.out.println("Filter3: " + str);
			return str + "->Filter3";
		};

		// Compose all functions resulting in a chain of operations.
		Function<String, String> appFilter = filter1.andThen(filter2).andThen(filter3);
		String result = appFilter.apply("gpcoder");
		System.out.println("Final data: " + result);
	}
}
