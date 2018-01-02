package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample7 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(50);
		myList.add(10);
		myList.add(20);
		myList.add(40);
		System.out.println("Elements before swap: " + myList);

		Collections.swap(myList, 0, 1);
		System.out.println("Elements after 0,1 swap: " + myList);

		Collections.swap(myList, 2, 3);
		System.out.println("Elements after 2,3 swap: " + myList);
	}
}
