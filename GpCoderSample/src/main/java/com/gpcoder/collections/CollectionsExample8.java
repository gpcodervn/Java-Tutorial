package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample8 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(30);
		myList.add(10);
		myList.add(20);
		myList.add(40);
		System.out.println("Elements before shuffle: " + myList);

		Collections.shuffle(myList);
		System.out.println("Elements after first shuffle: " + myList);

		Collections.shuffle(myList);
		System.out.println("Elements after second shuffle: " + myList);

		Collections.shuffle(myList);
		System.out.println("Elements after third shuffle: " + myList);
	}
}
