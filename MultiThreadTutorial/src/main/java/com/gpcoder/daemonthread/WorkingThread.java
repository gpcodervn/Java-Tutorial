package com.gpcoder.daemonthread;

public class WorkingThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			processSomething();
		}
	}

	private void processSomething() {
		try {
			System.out.println("Processing working thread");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
