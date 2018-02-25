package com.gpcoder.flow;

public class RunnableDemoTest {
	public static void main(String args[]) {
		System.out.println("Main thread running... ");
		
		RunnableDemo R1 = new RunnableDemo("Thread-1-HR-Database");
		R1.start();

		RunnableDemo R2 = new RunnableDemo("Thread-2-Send-Email");
		R2.start();
		
		System.out.println("==> Main thread stopped!!! ");
	}
}
