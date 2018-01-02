package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample9 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(50);
		myList.add(60);
		System.out.println("Elements myList before rotate: " + myList);

		Collections.rotate(myList, 3);
		System.out.println("Elements myList after rotate: " + myList);
	}
}
