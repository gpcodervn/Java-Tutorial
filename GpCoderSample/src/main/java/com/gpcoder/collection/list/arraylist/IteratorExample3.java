package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class IteratorExample3 {
	public static void main(String[] args) {
		// Create list with no parameter
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			// Add element to list
			list.add("0" + i);
		}

		for (int i = 0; i < 5; i++) {
			list.remove(i); // IndexOutOfBoundsException: Index: 3, Size: 2
		}

		for (String item : list) {
			list.remove(item); // ConcurrentModificationException
		}
	}
}
