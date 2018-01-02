package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample15 {
	public static void main(String args[]) {
		List list1 = new ArrayList();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);

		List list2 = Collections.checkedList(list1, Integer.class);
		System.out.println("list2 elements: " + list2);

		list1.add("hello");
		// list2.add("hello"); // throws ClassCastException

		HashSet set1 = new HashSet();
		set1.add("welcome");
		set1.add("to");
		set1.add("gpconder");
		Set set2 = Collections.checkedSet(set1, String.class);
		System.out.println("set2 elements: " + set2);

		set1.add(10);
		// secondSet.add(10); // throws ClassCastException

		Map map1 = new HashMap();
		map1.put(1, "one");
		map1.put(2, "two");
		map1.put(3, "three");
		Map map2 = Collections.checkedMap(map1, Integer.class, String.class);
		System.out.println("map2  elements: " + map2);

		// map2.put("4", "four"); // throws ClassCastException
	}
}
