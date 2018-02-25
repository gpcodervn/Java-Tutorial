package com.gpcoder.sync.staticmethod;

public class WorkingThread extends Thread {
	private String mThreadName;

	public WorkingThread(String threadName) {
		this.mThreadName = threadName;
	}

	@Override
	public void run() {
		ShareMemory.printData(mThreadName);
	}
}