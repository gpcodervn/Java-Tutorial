package com.gpcoder.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuture8_ThenCombine {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Retrieve weight: ");
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Retrieving weight...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("Retrieving weight: Completed!");
			return 65.0;
		});

		System.out.println("Retrieve height: ");
		CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Retrieving height...");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("Retrieving height: Completed!");
			return 177.8;
		});

		System.out.println("Calculating BMI: ");
		CompletableFuture<Double> combinedFuture = weightInKgFuture.thenCombine(heightInCmFuture,
				(weightInKg, heightInCm) -> {
					System.out.println("Calculating BMI: Completed!");
					Double heightInMeter = heightInCm / 100;
					return weightInKg / (heightInMeter * heightInMeter);
				});

		System.out.println("Your BMI is - " + combinedFuture.get());
	}
}
