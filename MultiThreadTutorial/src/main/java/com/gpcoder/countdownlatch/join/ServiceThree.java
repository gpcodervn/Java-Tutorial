package com.gpcoder.countdownlatch.join;

public class ServiceThree implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Started service three");
	}

}
