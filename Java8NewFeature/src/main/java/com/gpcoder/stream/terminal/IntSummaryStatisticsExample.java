package com.gpcoder.stream.terminal;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class IntSummaryStatisticsExample {

	public static void main(String[] args) {
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 10);

		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Count: " + stats.getCount());
		System.out.println("Max: " + stats.getMax());
		System.out.println("Min: " + stats.getMin());
		System.out.println("Sum: " + stats.getSum());
		System.out.println("Average: " + stats.getAverage());
	}
}
