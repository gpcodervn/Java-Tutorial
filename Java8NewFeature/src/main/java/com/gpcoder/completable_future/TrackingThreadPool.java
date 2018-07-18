package com.gpcoder.completable_future;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TrackingThreadPool extends ThreadPoolExecutor {

	// holds in-progress tasks
	private final Map<Runnable, Boolean> inProgress = new ConcurrentHashMap<Runnable, Boolean>();

	// Holds startime of the currently executing task.
	// Each thread has its own copy of this variable
	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	// global variable
	private volatile long totalTime; // in ms

	private volatile long totalTasks;

	private volatile String threadName;

	// Constructor
	public TrackingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, ThreadFactory factory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, factory);
	}

	// Called by each thread before executing a task
	// The executing thread is t and the executed task is r
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		threadName = t.getName();
		System.out.println("Thread running: " + threadName);

		super.beforeExecute(t, r);
		inProgress.put(r, Boolean.TRUE);

		// record the start time
		startTime.set(new Long(System.currentTimeMillis()));
	}

	// Called by each thread after executing the task
	// The executing thread is t and the executed task is r
	@Override
	protected void afterExecute(Runnable r, Throwable t) {

		// calculate the time taken by the task to execute
		long time = System.currentTimeMillis() - startTime.get().longValue();

		synchronized (this) {
			// update the stats of the pool
			totalTime += time;
			++totalTasks;
		}

		inProgress.remove(r);
		System.out.println("Thread Finished: " + threadName);
		super.afterExecute(r, t);
	}

	/**
	 * @return - returns the currently executing tasks
	 */
	public Set<Runnable> getInProgressTasks() {
		return Collections.unmodifiableSet(inProgress.keySet());
	}

	/**
	 * @return - returns the total tasks executed till that moment
	 */
	public synchronized long getTotalTasks() {
		return totalTasks;
	}

	/**
	 * @return - returns the average execution time of tasks in ms
	 */
	public synchronized double getAverageExecutionTime() {
		return (totalTasks == 0) ? 0 : totalTime / (double) totalTasks;
	}

	/**
	 * @return - returns the total execution time of tasks in ms
	 */
	public synchronized long getTotalExecutionTime() {
		return totalTime;
	}
}
