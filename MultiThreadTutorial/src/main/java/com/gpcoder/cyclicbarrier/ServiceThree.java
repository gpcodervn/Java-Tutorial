package com.gpcoder.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class ServiceThree implements Runnable {

	private final CyclicBarrier cyclicBarrier;

	public ServiceThree(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		System.out.println("Starting service Three....");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("Service Three has finished its work.. waiting for others...");
		try {
			cyclicBarrier.await();
		} catch (Exception e) {
			System.out.println("Service Three interrupted!");
			e.printStackTrace();
		}
		System.out.println("The wait is over, lets complete Service Three!");
	}
}
