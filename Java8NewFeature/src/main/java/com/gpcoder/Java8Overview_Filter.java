package com.gpcoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java8Overview_Filter {

	public static void main(String[] args) {
		beforeJava8();
		System.out.println();
		java8Lamda();
	}

	public static void beforeJava8() {
		List<Integer> numbers = createDummyData();
		Collections.sort(numbers);
		Stream<Integer> stream = numbers.stream().filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 1;
			}
		});
		stream.forEach(t -> System.out.print(t + " "));
	}

	public static void java8Lamda() {
		List<Integer> numbers = createDummyData();
		numbers.stream().sorted().filter(t -> t % 2 == 1).forEach(t -> System.out.print(t + " "));
	}

	private static List<Integer> createDummyData() {
		return Arrays.asList(9, 3, 1, 7, 6, 8, 2, 5, 4);
	}

}
