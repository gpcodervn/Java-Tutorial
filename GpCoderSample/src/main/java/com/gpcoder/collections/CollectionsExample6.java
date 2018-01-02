package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample6 {
	public static void main(String args[]) {
		List<String> firstList = new ArrayList<>();
		firstList.add("10");
		firstList.add("20");
		firstList.add("30");
		System.out.println("Elements firstList: " + firstList);

		List<String> secondList = new ArrayList<>();
		secondList.add("one");
		secondList.add("two");
		secondList.add("three");
		System.out.println("Elements secondList: " + secondList);

		Collections.copy(secondList, firstList);
		System.out.println("Elements of secondList after copying firstList: " + secondList);

		List<String> thirdList = new ArrayList<>();
		thirdList.add("one");
		thirdList.add("two");
		thirdList.add("three");
		thirdList.add("four");
		thirdList.add("five");
		System.out.println("\nElements thirdList: " + thirdList);

		Collections.copy(thirdList, firstList);
		System.out.println("Elements of thirdList after copying firstList: " + thirdList);
	}
}
