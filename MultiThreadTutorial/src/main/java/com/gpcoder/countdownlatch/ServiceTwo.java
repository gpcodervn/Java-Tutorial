package com.gpcoder.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ServiceTwo implements Runnable {

	private final CountDownLatch latch;

	public ServiceTwo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started service Two");
		latch.countDown();
	}

}
