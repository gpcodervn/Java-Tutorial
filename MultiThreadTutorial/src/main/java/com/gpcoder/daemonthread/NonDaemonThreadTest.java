package com.gpcoder.daemonthread;

public class NonDaemonThreadTest {
	public static void main(String[] args) throws InterruptedException {
		Thread dt = new Thread(new WorkingThread(), "My Non-Daemon Thread");
		dt.start();

		// continue program
		Thread.sleep(3000);
		System.out.println(">><< Finishing main program");
	}
}
