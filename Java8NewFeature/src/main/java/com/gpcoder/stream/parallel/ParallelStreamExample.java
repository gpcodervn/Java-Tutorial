package com.gpcoder.stream.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreamExample {

	public static void main(String[] args) {
		List<String> values = createDummyData();

		long startTime = System.nanoTime();

		long count = values.parallelStream().sorted().count();
		System.out.println(count);

		long endTime = System.nanoTime();

		long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

		System.out.println(String.format("parallel sort took: %d ms", millis));
		// parallel sort took: 489 ms

	}

	public static List<String> createDummyData() {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		return values;
	}
}
