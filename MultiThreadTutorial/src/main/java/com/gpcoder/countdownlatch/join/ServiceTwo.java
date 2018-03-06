package com.gpcoder.countdownlatch.join;

public class ServiceTwo implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started service Two");
	}

}
