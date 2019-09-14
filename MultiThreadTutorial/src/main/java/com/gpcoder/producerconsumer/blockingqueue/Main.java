package com.gpcoder.producerconsumer.blockingqueue;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> boundedBuffer = new BlockingQueue<>();

		Producer producer = new Producer(boundedBuffer);
		Consumer consumer1 = new Consumer(boundedBuffer);
		Consumer consumer2 = new Consumer(boundedBuffer);
		Consumer consumer3 = new Consumer(boundedBuffer);

		new Thread(producer).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
		
		Thread.sleep(5000); // After 5s have another comsumer
		Consumer consumer4 = new Consumer(boundedBuffer);
		new Thread(consumer4).start();
	}
}