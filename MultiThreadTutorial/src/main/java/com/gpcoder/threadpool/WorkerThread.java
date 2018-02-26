package com.gpcoder.threadpool;

public class WorkerThread implements Runnable {

	private String task;

	public WorkerThread(String s) {
		this.task = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Starting. Task = " + task);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " Finished.");
	}

	private void processCommand() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}