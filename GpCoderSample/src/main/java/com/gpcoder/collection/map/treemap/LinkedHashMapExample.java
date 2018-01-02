package com.gpcoder.collection.map.treemap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LinkedHashMapExample {
	public static void main(String args[]) {
		// init map
		Map<Integer, String> map = new TreeMap<Integer, String>();
		map.put(1, "Basic java");
		map.put(2, "OOP");
		map.put(4, "Multi-Thread");
		map.put(3, "Collection");

		// show map using method keySet()
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}

		System.out.println("---");

		// show map using method keySet()
		for (Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
}
