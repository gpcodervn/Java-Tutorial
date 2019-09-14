package com.gpcoder.producerconsumer.semaphore;

import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerSemaphore {

	private static final int BUFFER_SIZE = 4;
	private final Semaphore writePermits = new Semaphore(BUFFER_SIZE);
	private final Semaphore readPermits = new Semaphore(0);
	private final Stack<Integer> buffer = new Stack<>();

	class Producer implements Runnable {
		private String name;

		public Producer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(name + ": acquiring lock...");
					System.out.println(name + ": Producer available Semaphore permits now: " + writePermits.availablePermits());
					writePermits.acquire();
					System.out.println(name + ": got the permit!");

					Thread.sleep(50); // simulate time to work
					int data = ThreadLocalRandom.current().nextInt(100);
					System.out.println(name + ": produced data " + buffer.push(data));

					System.out.println(name + ": releasing lock...");
					readPermits.release();
					System.out.println(name + ": Consumer available Semaphore permits now: " + readPermits.availablePermits());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class Consumer implements Runnable {
		private String name;

		public Consumer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(name + ": acquiring lock...");
					System.out.println(name + ": Consumer available Semaphore permits now: " + readPermits.availablePermits());
					readPermits.acquire();

					Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300)); // simulate time to work
					System.out.println(name + ": consumed data " + buffer.pop());

					System.out.println(name + ": releasing lock...");
					writePermits.release();
					System.out.println(name + ": Producer available Semaphore permits now: " + writePermits.availablePermits());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerSemaphore obj = new ProducerConsumerSemaphore();
		Producer producer = obj.new Producer("Producer 1");
		new Thread(producer).start();
		
		for (int i = 1; i <= 3; i++) {
			Consumer consumer = obj.new Consumer("Consumer " + i);
			new Thread(consumer).start();
		}
		
		Thread.sleep(5000); // After 5s have another comsumer
		Consumer consumer = obj.new Consumer("Consumer " + 4);
		new Thread(consumer).start();
	}
}
