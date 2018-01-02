package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample12 {
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(100);
		list1.add(20);
		list1.add(30);
		list1.add(400);

		List<Integer> list2 = new ArrayList<>();
		list2.add(20);
		list2.add(30);

		List<Integer> list3 = new ArrayList<>();
		list3.add(20);
		list3.add(40);

		System.out.println("list1 elements: " + list1);
		System.out.println("list2 elements: " + list2);
		System.out.println("list3 elements: " + list3);
		
		int num1 = Collections.indexOfSubList(list1, list2);
		System.out.println("\nFirst index list2 in list1: " + num1);

		int num2 = Collections.lastIndexOfSubList(list1, list2);
		System.out.println("Last index list2 in list1: " + num2);

		int num3 = Collections.lastIndexOfSubList(list1, list3);
		System.out.println("\nFirst index num3 in list1: " + num3);

		int num4 = Collections.lastIndexOfSubList(list1, list3);
		System.out.println("Last index num3 in list1: " + num4);
	}
}
