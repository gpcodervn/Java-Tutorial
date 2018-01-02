package com.gpcoder.collections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample16 {
	public static void main(String args[]) {
		List<Integer> list = Collections.singletonList(new Integer(10));
		System.out.println("list elements: " + list);

		// list.add(20); // throws UnsupportedOperationException

		Set<String> set = Collections.singleton("Welcome to gpcoder.com");
		System.out.println("set elements: " + set);

		// set.add("world"); // throws UnsupportedOperationException

		Map<Integer, String> map = Collections.singletonMap(1, "one");
		System.out.println("map elements: " + map);

		// map1.put(2, "two"); // throws UnsupportedOperationException
	}
}
