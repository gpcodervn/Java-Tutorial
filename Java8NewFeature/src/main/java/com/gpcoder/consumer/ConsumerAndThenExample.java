package com.gpcoder.consumer;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

	public static final int TEST_NUMBER = 5;

	public static void main(String[] args) {

		Consumer<Integer> times2 = (e) -> System.out.println(e * 2);
		Consumer<Integer> squared = (e) -> System.out.println(e * e);
		Consumer<Integer> isOdd = (e) -> System.out.println(e % 2 == 1);

		// perform every consumer
		times2.accept(TEST_NUMBER); // 10
		squared.accept(TEST_NUMBER); // 25
		isOdd.accept(TEST_NUMBER); // true

		// perform 3 methods in sequence
		Consumer<Integer> combineConsumer = times2.andThen(squared).andThen(isOdd);
		combineConsumer.accept(TEST_NUMBER); // 10 25 true
	}
}