package com.gpcoder;

public class DebugWithLoop {
	public static void main(String[] args) {
		Counter counter = new Counter();
		counter.count();
		System.out.println("We have counted " + counter.getResult());
	}
}

class Counter {
	private int result = 0;

	public int getResult() {
		return result;
	}

	public void count() {
		for (int i = 0; i < 100; i++) {
			result += i + 1;
		}
	}
}