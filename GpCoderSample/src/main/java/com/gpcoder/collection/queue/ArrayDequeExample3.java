package com.gpcoder.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample3 {
	public static void main(String[] args) {
		// Creating Deque and adding elements
		Deque<String> deque = new ArrayDeque<String>();
		deque.add("Basic");
		deque.add("OOP");
		deque.add("Collection");
		// Traversing elements
		for (String str : deque) {
			System.out.println(str);
		}
	}
}
