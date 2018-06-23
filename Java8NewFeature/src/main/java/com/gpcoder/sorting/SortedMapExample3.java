package com.gpcoder.sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortedMapExample3 {

	public static void main(String[] args) {
		// Original data
		Map<Integer, String> map = new HashMap<>();
		map.put(44, "Four");
		map.put(22, "Two");
		map.put(33, "Three");
		map.put(55, "Five");
		map.put(11, "One");
		
		// sort by key
		Map<Integer, String> sortedMapByKey = new LinkedHashMap<>();
		map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey())
                .forEachOrdered(e -> sortedMapByKey.put(e.getKey(), e.getValue()));
		
		// sort by value
		Map<Integer, String> sortedMapByValue = new LinkedHashMap<>();
		map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue())
                .forEachOrdered(e -> sortedMapByValue.put(e.getKey(), e.getValue()));

        // print map
		System.out.println("Original map: " + map);
		System.out.println("Sorted map by key: " + sortedMapByKey);
		System.out.println("Sorted map by value: " + sortedMapByValue);
	}
}
