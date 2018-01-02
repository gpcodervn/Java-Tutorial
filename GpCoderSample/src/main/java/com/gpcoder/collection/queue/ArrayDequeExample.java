package com.gpcoder.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
	public static void main(String[] args) {
		// Creating an array deque
		Deque<String> arrayDeque = new ArrayDeque<String>();

		// Adding elements at the tail of arrayDeque
		arrayDeque.offer("One");
		arrayDeque.offer("Two");
		arrayDeque.offer("Three");
		arrayDeque.offer("Four");
		arrayDeque.offer("Five");

		// Printing the elements of arrayDeque
		System.out.println(arrayDeque); // Output : [One, Two, Three, Four, Five]

		// Removing the elements from the head of arrayDeque
		System.out.println(arrayDeque.poll()); // Output : One
		System.out.println(arrayDeque.poll()); // Output : Two
	}
}
