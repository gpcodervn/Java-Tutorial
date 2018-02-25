package com.gpcoder.daemonthread;

public class DaemonThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Thread dt = new Thread(new WorkingThread(), "My Daemon Thread");
		dt.setDaemon(true);
		dt.start();

		// continue program
		Thread.sleep(3000);
		System.out.println(">><< Finishing main program");
	}

}
