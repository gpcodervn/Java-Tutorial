package com.gpcoder.sync.staticmethod;

public class ShareMemoryTest {

	public static void main(String[] args) {

		WorkingThread thread1 = new WorkingThread("Thread1");
		WorkingThread thread2 = new WorkingThread("Thread2");
		WorkingThread thread3 = new WorkingThread("Thread3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
