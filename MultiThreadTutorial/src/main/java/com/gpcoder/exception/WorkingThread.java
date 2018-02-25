package com.gpcoder.exception;

import java.util.Random;

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

		Random r = new Random();
		int i = r.nextInt(100);
		if (i > 70) {
			throw new RuntimeException("Simulate an exception was not handled in the thread");
		}
	}

}
