package com.gpcoder.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollectionExample3 {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			list.add("0" + i);
		}

		System.out.print("Using For Size: ");
		for (int i = 0; i < NUM_OF_ELEMENT; i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println();
		System.out.print("Using Foreach: ");
		for (String item : list) {
			System.out.print(item + " ");
		}

		System.out.println();
		System.out.print("Using For Iterator: ");
		for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
			System.out.print(iter.next() + " ");
		}

		System.out.println();
		System.out.print("Using While ListIterator: ");
		ListIterator<String> listIter = list.listIterator();
		while (listIter.hasNext()) {
			System.out.print(listIter.next() + " ");
		}

		System.out.println();
		System.out.print("Using While Iterator: ");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}

		System.out.println();
		System.out.print("While While Size: ");
		int i = 0;
		while (i < NUM_OF_ELEMENT) {
			System.out.print(list.get(i) + " ");
			i++;
		}

		System.out.println();
		System.out.print("ForEach Java8: ");
		list.forEach(s -> System.out.print(s + " "));

		System.out.println();
		System.out.print("Stream ForEach Java8: ");
		list.stream().forEach(s -> System.out.print(s + " "));
	}
}
