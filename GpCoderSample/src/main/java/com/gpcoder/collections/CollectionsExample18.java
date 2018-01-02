package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class CollectionsExample18 {
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		System.out.println("list1 elements: " + list1);

		Enumeration<Integer> e = Collections.enumeration(list1);

		System.out.print("list1 elements using Enumeration: ");
		while (e.hasMoreElements()) {
			Object obj = e.nextElement();
			System.out.print(obj + " ");
		}
	}
}
