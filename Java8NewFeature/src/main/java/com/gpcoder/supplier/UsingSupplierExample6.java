package com.gpcoder.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RandomNumbers {
	public static Integer getNext() {
		return new Random().nextInt(10);
	}
}

public class UsingSupplierExample6 {

	public static void main(String[] args) {
		randomNumbersGreaterThan5ByUsingLoop();
		randomNumbersGreaterThan5ByUsingSupplier();
	}

	public static void randomNumbersGreaterThan5ByUsingLoop() {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Integer number = RandomNumbers.getNext();
			if (number > 5) {
				randomNumbers.add(number);
			}
		}

		System.out.println(randomNumbers);
	}

	public static void randomNumbersGreaterThan5ByUsingSupplier() {
		Supplier<Integer> supplier = () -> RandomNumbers.getNext();

		List<Integer> randomNumbers = Stream.generate(supplier)
				.filter(number -> number > 5)
				.limit(10)
				.collect(Collectors.toList());

		System.out.println(randomNumbers);
	}
}
