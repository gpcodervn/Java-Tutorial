package com.gpcoder.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortedMapExample2 {

	public static void main(String[] args) {
		// Original data
		Map<Integer, String> map = new HashMap<>();
		map.put(44, "Four");
		map.put(22, "Two");
		map.put(33, "Three");
		map.put(55, "Five");
		map.put(11, "One");

		// Convert list to map
		List<Map.Entry<Integer, String>> list1 = new ArrayList<>(map.entrySet());

		// Create a comparator to sort by value
		Comparator<Entry<Integer, String>> valueComparator = new Comparator<Entry<Integer, String>>() {
			@Override
			public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		};

		// Sorting a List
		Collections.sort(list1, valueComparator);

		// Convert List to Map
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> entry : list1) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println("Original map: " + map);
		System.out.println("Sorted map: " + sortedMap);
	}
}
