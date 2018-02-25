package com.gpcoder.simple;

public class TheadSimple extends Thread {
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		TheadSimple t1 = new TheadSimple();
		t1.start();
	}
}
