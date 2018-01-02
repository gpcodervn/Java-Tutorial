package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample2 {
	public static void main(String[] args) {
		// Create list with no parameter
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			// Add element to list
			list.add("0" + i);
		}

		Iterator<String> iterator = list.iterator();
		System.out.println("Using Iterator: Only Traversing the list in the forward direction ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
			iterator.remove();
		}
		System.out.println();
		System.out.println("list.isEmpty() = " + list.isEmpty());
	}
}
