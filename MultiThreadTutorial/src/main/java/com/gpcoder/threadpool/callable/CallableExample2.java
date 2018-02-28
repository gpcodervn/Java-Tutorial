package com.gpcoder.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableExample2 {
	public static final int GET_TIME_OUT = 5;
	public static final int NUM_OF_TASK = 10;

	public static void main(String[] args) throws TimeoutException, InterruptedException {
		// create a list to hold the Future object associated with Callable
		List<Future<Integer>> list = new ArrayList<>();

		// Get ExecutorService from Executors utility class, thread pool size is 5
		ExecutorService executor = Executors.newFixedThreadPool(5);

		Callable<Integer> callable;
		Future<Integer> future;
		for (int i = 1; i <= NUM_OF_TASK; i++) {
			callable = new CallableWorker(i);

			// submit Callable tasks to be executed by thread pool
			future = executor.submit(callable);

			// add Future to the list, we can get return value using Future
			list.add(future);
		}

		int sum = 0;
		for (Future<Integer> f : list) {
			try {
				// print the return value of Future, notice the output delay in console
				// because Future.get() waits for task to get completed
				int result = f.get(GET_TIME_OUT, TimeUnit.SECONDS);
				// Throw TimeoutException if the task execute over 7s
				sum += result;
				System.out.println("Result: " + result);
				System.out.println("Is completed? : " + f.isDone());
				System.out.println("Is canceled? : " + f.isCancelled());
			} catch (TimeoutException | CancellationException | InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("---");
		}

		// shut down the executor service now
		executor.shutdownNow();

		// Blocks until all tasks have completed execution after a shutdown request, or
		// the timeout occurs, or the current thread is interrupted, whichever happens
		// first.
		while (!executor.awaitTermination(GET_TIME_OUT * NUM_OF_TASK * 1000, TimeUnit.SECONDS)) {
			// Running ...
		}

		System.out.println("Finished all threads");
		System.out.println("Sum all = " + sum);
	}
}
