package com.gpcoder.simple;

public class RunnableSimple implements Runnable {
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		RunnableSimple runable = new RunnableSimple();
		Thread t1 = new Thread(runable);
		t1.start();
	}
}
