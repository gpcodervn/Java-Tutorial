package com.gpcoder.collection.list.vector;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayIteratorExample {
	public static void main(String args[]) {
		// creating arraylist
		ArrayList<String> arrayList = new ArrayList<String>();

		// adding object in arraylist
		arrayList.add("Sonoo");
		arrayList.add("Michael");
		arrayList.add("James");
		arrayList.add("Andy");

		// traversing elements using Iterator
		Iterator<String> itr = arrayList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
