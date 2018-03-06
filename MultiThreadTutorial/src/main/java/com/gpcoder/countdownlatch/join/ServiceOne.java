package com.gpcoder.countdownlatch.join;

public class ServiceOne implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started service One");
	}
}
