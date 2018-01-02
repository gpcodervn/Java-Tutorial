package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample10 {
	public static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		System.out.println("Elements before fill: " + myList);

		Collections.fill(myList, 0);
		System.out.println("Elements after fill: " + myList);

		List<String> namesList = new ArrayList<>();
		namesList.add("wellcome");
		namesList.add("to");
		namesList.add("gpcoder");
		System.out.println("\nElements before fill: " + namesList);

		Collections.fill(namesList, null);
		System.out.println("Elements after fill: " + namesList);
	}
}
