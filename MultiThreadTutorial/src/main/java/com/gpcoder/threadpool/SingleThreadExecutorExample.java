package com.gpcoder.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorExample {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 1; i <= 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executor.execute(worker);
		}

		/*
		 * Initiates an orderly shutdown in which previously submitted tasks are
		 * executed, but no new tasks will be accepted. Invocation has no additional
		 * effect if already shut down. This method does not wait for previously
		 * submitted tasks to complete execution. Use awaitTermination to do that.
		 */
		executor.shutdown();

		// Wait until all threads are finish
		while (!executor.isTerminated()) {
			// Running ...
		}

		System.out.println("Finished all threads");
	}
}
