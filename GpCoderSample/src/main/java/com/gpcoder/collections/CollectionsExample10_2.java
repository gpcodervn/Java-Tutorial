package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample10_2 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		System.out.println("Elements myList before replacing: " + myList);

		boolean success = Collections.replaceAll(myList, 10, 100);
		System.out.println("Replace operation successful: " + success);
		System.out.println("Elements after replacing: " + myList);

		success = Collections.replaceAll(myList, 50, 200);
		System.out.println("Replace operation successful: " + success);
		System.out.println("Elements after replacing: " + myList);
	}
}
