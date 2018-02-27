package com.gpcoder.threadpool.custom;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {

	public static void main(String args[]) throws InterruptedException {

		// the number of threads to keep in the pool, even if they are idle
		final int CORE_POOL_SIZE = 2; //

		// the maximum number of threads to allow in the pool
		final int MAX_POOL_SIZE = 4;

		// the queue to use for holding tasks before they are executed
		final long KEEP_ALIVE_TIME = 10;

		// the queue to use for holding tasks before they are executed. This queue will
		// hold only the Runnable tasks submitted by the execute method.
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);

		// RejectedExecutionHandler implementation
		RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();

		// The handler to use when execution is blocked because the thread bounds
		// and queue capacities are reached
		// ThreadFactory threadFactory = Executors.defaultThreadFactory();
		ThreadFactory threadFactory = new ThreadFactoryBuilder()
				.setNamePrefix("GPCoder-ThreadPool")
				.setDaemon(false)
				.setPriority(Thread.MAX_PRIORITY)
				.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.err.println(String.format("Custom Exception: Thread %s threw exception - %s",
								t.getName(), e.getMessage()));

					}
				}).build();

		// creating the ThreadPoolExecutor
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(
				CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
				TimeUnit.SECONDS, workQueue, threadFactory, rejectionHandler);

		// start the monitoring thread
		MonitorThread monitor = new MonitorThread(executorPool, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();

		// submit work to the thread pool
		for (int i = 1; i <= 10; i++) {
			executorPool.execute(new WorkerThread("cmd" + i));
		}

		Thread.sleep(30000);

		// shut down the pool
		executorPool.shutdown();

		// shut down the monitor thread
		Thread.sleep(5000);
		monitor.shutdown();

	}
}
