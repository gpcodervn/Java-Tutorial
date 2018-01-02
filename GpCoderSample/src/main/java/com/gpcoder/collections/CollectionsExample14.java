package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample14 {
	public static void main(String args[]) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		List<Integer> list2 = Collections.synchronizedList(list1);
		System.out.println("list2 elements: " + list2);

		HashSet<String> set1 = new HashSet<String>();
		set1.add("welcome");
		set1.add("to");
		set1.add("gpconder");
		Set<String> set2 = Collections.synchronizedSet(set1);
		System.out.println("set2 elements: " + set2);

		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		Map<Integer, String> map2 = Collections.synchronizedMap(map1);
		System.out.println("map2 elements: " + map2);
	}
}
