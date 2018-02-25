package com.gpcoder.join;

public class UsingJoinMethod2 extends Thread {

	public UsingJoinMethod2(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(getName());
		for (int i = 1; i <= 5; i++) {
			try {
				System.out.print(i + " ");
				Thread.sleep(300);
			} catch (InterruptedException ie) {
				System.out.println(ie.toString());
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws InterruptedException {
		UsingJoinMethod2 t1 = new UsingJoinMethod2("Thread 1");
		UsingJoinMethod2 t2 = new UsingJoinMethod2("Thread 2");
		t1.start();

		// Main Thread phải chờ 450ms mới được tiếp tục chạy.
		// Không nhất thiết phải chờ Thread t1 kết thúc
		t1.join(450);

		t2.start();
		System.out.println("Main Thread Finished");
	}
}