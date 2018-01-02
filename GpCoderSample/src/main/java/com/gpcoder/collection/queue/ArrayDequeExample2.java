package com.gpcoder.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample2 {
	public static void main(String[] args) {
		// Creating an array deque
		Deque<String> arrayDeque = new ArrayDeque<String>();

		// pushing elements into arrayDeque
		arrayDeque.push("One");
		arrayDeque.push("Two");
		arrayDeque.push("Three");
		arrayDeque.push("Four");
		arrayDeque.push("Five");

		// Printing the elements of arrayDeque
		System.out.println(arrayDeque); // Output : [Five, Four, Three, Two, One]

		// popping up the elements from arrayDeque
		System.out.println(arrayDeque.pop()); // Output : Five
		System.out.println(arrayDeque.pop()); // Output : Four
	}
}
