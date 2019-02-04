package com.gpcoder.completable_future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Complete the first level before running the second level
 */
public class ConcurrencyWithCompletableFuture2 {

	public static void main(String[] args) {
		
		List<String> allPerson = new ArrayList<>();
		allPerson.add("A");
		allPerson.add("B");
		allPerson.add("C");
		allPerson.add("D");
		allPerson.add("E");

		List<CompletableFuture<List<String>>> work1Futures = allPerson.stream()
				.map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> work1(s)))
				.collect(Collectors.toList());
		
		List<CompletableFuture<String>> work2Futures = new ArrayList<>();
		
		CompletableFuture<Void> allOfWork1 = CompletableFuture.allOf(work1Futures.toArray(new CompletableFuture[work1Futures.size()]))
				.whenComplete((v, th) -> {
					work1Futures.forEach(work1Result -> work2Futures.addAll(work1Result.getNow(null).stream().map(child -> CompletableFuture.completedFuture(child))
							.collect(Collectors.toList())));
				});
		allOfWork1.join();
		
		CompletableFuture<Void> allOfWork2 = CompletableFuture.allOf(work2Futures.toArray(new CompletableFuture[work2Futures.size()]))
				.whenComplete((v, th) -> {
					work2Futures.forEach(cf -> work2(cf.getNow(null)));
					// Do something when complete
				});
		allOfWork2.join();
	}

	private static List<String> work1(String _item) {
		System.out.println("Person" + _item + " -> work1");
		return Arrays.asList(_item + "_item" + 1, _item + "_item" + 2);
	}

	private static void work2(String data) {
		System.out.println("Person" + data + " -> work2");
	}
}
