package com.gpcoder.completable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompletableFuture14_Cancelled {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<String> list = new ArrayList<>();

		AtomicBoolean cancelled = new AtomicBoolean(false);

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			while (true) {
				if (cancelled.get()) {
					System.out.println("cancelled");
					return list.size();
				}
				if (!list.isEmpty()) {
					return list.size();
				}
			}
		});

		TimeUnit.SECONDS.sleep(3);

		try {
			future.get(1, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			cancelled.set(true);
		}
		System.out.println(future.get());
	}
}
