package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample5 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(10);
		System.out.println("Elements of ArrayList: " + myList);
		System.out.println("No. of times 10 exists: " + Collections.frequency(myList, 10));
		System.out.println("No. of times 20 exists: " + Collections.frequency(myList, 20));
		System.out.println("No. of times 30 exists: " + Collections.frequency(myList, 30));
	}
}
