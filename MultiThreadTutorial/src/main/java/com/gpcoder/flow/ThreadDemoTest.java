package com.gpcoder.flow;

public class ThreadDemoTest {
	public static void main(String args[]) {
		System.out.println("Main thread running... ");

		ThreadDemo T1 = new ThreadDemo("Thread-1-HR-Database");
		T1.start();

		ThreadDemo T2 = new ThreadDemo("Thread-2-Send-Email");
		T2.start();

		System.out.println("==> Main thread stopped!!! ");
	}
}
