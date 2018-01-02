package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample13 {
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		List<Integer> list2 = Collections.unmodifiableList(list1);
		System.out.println("list2 elements: " + list2);

		// list2.add(50); // throws UnsupportedOpearationException

		System.out.println("\nlist1 elements before adding 50: " + list1);
		list1.add(50);
		System.out.println("list1 elements after adding 50: " + list1);

		Set<String> set1 = new HashSet<>();
		set1.add("welcome");
		set1.add("to");
		set1.add("gpconder");
		Set<String> set2 = Collections.unmodifiableSet(set1);
		System.out.println("\nset2 elements: " + set2);

		// set2.add("sir"); // throws UnsupportedOpearationException

		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		Map<Integer, String> map2 = Collections.unmodifiableMap(map1);
		System.out.println("map2 elements: " + map2);

		// map2.put(4, "four"); // throws UnsupportedOpearationException
	}
}
