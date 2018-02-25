package com.gpcoder.exception;

public class ThreadExceptionDemo {

	public static void main(String[] args) {
		System.out.println("==> Main thread running...");

		Thread thread = new Thread(new WorkingThread());
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("#Thread: " + t);
				System.out.println("#Thread exception message: " + e.getMessage());
			}
		});

		thread.start();
		System.out.println("==> Main thread end!!!");
	}
}