package com.gpcoder.consumer;

import java.util.Arrays;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class ConsumerExample3 {

	public static void main(String[] args) {

		System.out.print("IntConsumer: ");
		int[] intNumbers = { 3, 5, 6, 2, 1 };
		IntConsumer intConsumer = i -> System.out.print(i + " ");
		Arrays.stream(intNumbers).forEach(intConsumer);

		System.out.print("\nLongConsumer: ");
		long[] longNumbers = { 3, 5, 6, 2, 1 };
		LongConsumer longConsumer = l -> System.out.print(l + " ");
		Arrays.stream(longNumbers).forEach(longConsumer);

		System.out.print("\nDoubleConsumer: ");
		double[] dbNumbers = { 3.2, 5.1, 6.3, 2.5, 1.0 };
		DoubleConsumer dbConsumer = d -> System.out.print(d + " ");
		Arrays.stream(dbNumbers).forEach(dbConsumer);
	}
}
