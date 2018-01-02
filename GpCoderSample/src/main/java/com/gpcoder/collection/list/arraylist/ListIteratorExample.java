package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
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
		}

		System.out.println();
		ListIterator<String> itr = list.listIterator();
		System.out.println("Using ListIterator: Traversing the list in the forward direction ");
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();
		System.out.println("Using ListIterator: Traversing the list in the reverse direction ");
		while (itr.hasPrevious()) {
			System.out.print(itr.previous() + " ");
		}

	}
}
