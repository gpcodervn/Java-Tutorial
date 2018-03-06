package com.gpcoder.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class ServiceThree implements Runnable {

	private final CountDownLatch latch;

	public ServiceThree(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started service three");
		latch.countDown();
	}

}
