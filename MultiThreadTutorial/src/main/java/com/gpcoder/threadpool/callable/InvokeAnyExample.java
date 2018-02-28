package com.gpcoder.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnyExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Get ExecutorService from Executors utility class, thread pool size is 5
		ExecutorService executor = Executors.newFixedThreadPool(5);

		List<Callable<Integer>> callables = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			callables.add(new CallableWorker(i));
		}

		Integer result = executor.invokeAny(callables);
		System.out.println("Result = " + result);

		executor.shutdown();
		System.out.println("Finished all threads ");
	}

}
