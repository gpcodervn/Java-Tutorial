package com.gpcoder.completable_future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * All level is running with multi-thread
 */
public class ConcurrencyWithCompletableFuture3 {

	public static void main(String[] args) {
		List<String> works = new ArrayList<>();
		works.add("A");
		works.add("B");
		works.add("C");
		works.add("D");
		works.add("E");
		runMultipleAsync(works);
	}

	private static void runMultipleAsync(List<String> works) {
		List<CompletableFuture<List<Void>>> allOfWork1Futures = new ArrayList<>();
		works.stream().forEach(work -> {
			allOfWork1Futures.add(createWork1(work).thenCompose(work1Results -> {
				List<CompletionStage<Void>> allOfWork2Futures = work1Results.stream()
						.map(work1Result -> createWork2(work1Result)).collect(Collectors.toList());
				CompletableFuture<Void> done = CompletableFuture
						.allOf(allOfWork2Futures.toArray(new CompletableFuture[allOfWork2Futures.size()]));
				return done.thenApplyAsync(v -> allOfWork2Futures.stream().map(CompletionStage::toCompletableFuture)
						.map(CompletableFuture::join) // Returns the result value when complete
						.collect(Collectors.toList()));
			}).whenCompleteAsync((result, th) -> {
				// Do something when complete
			}).toCompletableFuture());
		});
		CompletableFuture<Void> done = CompletableFuture
				.allOf(allOfWork1Futures.toArray(new CompletableFuture[allOfWork1Futures.size()]))
				.whenComplete((result, th) -> {
					// Do something when complete
				});
		done.join(); // Returns the result value when complete
	}

	private static CompletionStage<List<String>> createWork1(String str) {
		return CompletableFuture.completedFuture(str).thenApplyAsync(s -> executeWork1(s));
	}

	private static CompletionStage<Void> createWork2(String str) {
		return CompletableFuture.completedFuture(str).thenAcceptAsync(s -> executeWork2(s));
	}

	private static List<String> executeWork1(String _item) {
		waitingForComplete();
		System.out.println("Work" + _item + " -> work1");
		return Arrays.asList(_item + "_item" + 1, _item + "_item" + 2);
	}

	private static void executeWork2(String data) {
		waitingForComplete();
		System.out.println("Work" + data + " -> work2");
	}

	private static void waitingForComplete() {
		try {
			TimeUnit.SECONDS.sleep(random(0, 3));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static int random(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
