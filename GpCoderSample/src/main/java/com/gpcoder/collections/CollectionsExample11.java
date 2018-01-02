package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample11 {
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);

		List<Integer> list2 = new ArrayList<>();
		list2.add(60);
		list2.add(40);
		list2.add(20);

		List<Integer> list3 = new ArrayList<>();
		list3.add(60);
		list3.add(40);
		list3.add(50);

		System.out.println("Elements of list1: " + list1);
		System.out.println("Elements of list2: " + list2);
		System.out.println("Elements of list3: " + list3);

		boolean exists = Collections.disjoint(list1, list2);
		System.out.println("\nlist1 and list2 contains same elements: " + exists); // false

		exists = Collections.disjoint(list1, list3);
		System.out.println("list1 and list3 contains same elements: " + exists); // true
	}
}
