package com.gpcoder.producerconsumer.blockingqueue;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

	private final BlockingQueue<Integer> queue;

	Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			while (true) {
				queue.put(produce());
				System.out.println("Produced resource - Queue size() = "  + queue.size());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Integer produce() throws InterruptedException {
		Thread.sleep(50); // simulate time to produce the data
		return ThreadLocalRandom.current().nextInt(1, 100);
	}
}