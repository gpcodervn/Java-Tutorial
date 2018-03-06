package com.gpcoder.countdownlatch.join;


public class ThreadJoinExample {

	public static void main(String[] args) {

		// making two threads for 3 services
		Thread service1 = new Thread(new ServiceOne());
		Thread service2 = new Thread(new ServiceTwo());
		Thread service3 = new Thread(new ServiceThree());

		service1.start();
		service2.start();
		service3.start();

		// using thread.join() to make sure that the execution of main thread only
		// finishes ones 3 services have executed
		try {
			System.out.println("Waiting for 3 services have started ... ");
			service1.join();
			service2.join();
			service3.join();
			System.out.println("Starting main Thread ... ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done!!!");
	}

}
