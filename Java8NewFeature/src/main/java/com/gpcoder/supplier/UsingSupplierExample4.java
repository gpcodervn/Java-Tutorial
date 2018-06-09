package com.gpcoder.supplier;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

class LoadLargeDataService {
	public static String doSomething() {
		System.out.println("Do something ...");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Done";
	}
}

public class UsingSupplierExample4 {

	public static void main(String[] args) {

		trackingMe(LoadLargeDataService::doSomething);
		trackingMe(LoadLargeDataService::doSomething);
	}

	private static void trackingMe(Supplier<String> supplier) {
		Instant start = Instant.now();
		supplier.get(); // invoke data
		Instant end = Instant.now();

		Duration elapsed = Duration.between(start, end);
		System.out.printf("Executed in %d ms\n", elapsed.toMillis());
	}
}
