package com.gpcoder.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuture1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		System.out.println("Manually complete");
		completableFuture.complete(computeSomething());

		System.out.print("Get the result: ");
		String result = completableFuture.get();
		System.out.println(result);
	}

	public static String computeSomething() {
		try {
			System.out.println("Computing ... ");
			Thread.sleep(3000);
			System.out.println("Compute completed ... ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Future's Result";
	}
}
