package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		// Create list with no parameter
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			// Add element to list
			list.add("0" + i);
		}

		// traversing the list in the backward direction
		for (int i = 4; i >= 0; i--) {
			list.remove(i);
		}
		System.out.println("list.isEmpty() = " + list.isEmpty());
	}
}
