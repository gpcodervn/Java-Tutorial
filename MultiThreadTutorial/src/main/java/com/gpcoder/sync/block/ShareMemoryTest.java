package com.gpcoder.sync.block;

public class ShareMemoryTest {

	public static void main(String[] args) {

		ShareMemory sm = new ShareMemory();
		WorkingThread thread1 = new WorkingThread(sm, "Thread1");
		WorkingThread thread2 = new WorkingThread(sm, "Thread2");
		WorkingThread thread3 = new WorkingThread(sm, "Thread3");

		thread1.start();
		thread2.start();
		thread3.start();
	}

}
