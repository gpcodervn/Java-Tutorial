package com.gpcoder.info;

public class ThreadInfoExample {

	public static void main(String[] args) {
		Thread t1 = new WorkingThread("Luồng 1");
		Thread t2 = new WorkingThread("Luồng 2");
		Thread t3 = new WorkingThread("Luồng 3");

		System.out.println("ID luồng 1: " + t1.getId());
		System.out.println("ID luồng 2: " + t2.getId());
		System.out.println("ID luồng 3: " + t3.getId());

		t1.setPriority(1);
		t2.setPriority(5);
		t3.setPriority(10);

		t1.start();
		t2.start();
		t3.start();
	}

}
