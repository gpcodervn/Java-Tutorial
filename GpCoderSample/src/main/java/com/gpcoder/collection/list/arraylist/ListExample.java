package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		// Create list with no parameter
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			// Add element to list
			list.add("0" + i);
		}

		// Show list through for-each
		for (String item : list) {
			System.out.print(item + " ");
		}
	}
}
