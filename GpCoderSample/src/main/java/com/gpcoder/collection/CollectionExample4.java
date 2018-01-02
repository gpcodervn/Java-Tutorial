package com.gpcoder.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExample4 {
	public static final int NUM_OF_ELEMENT = 5;
	
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			arrayList.add("0" + i);
		}
		System.out.println("ArrayList: " + arrayList);

		List<String> linkedList = new LinkedList<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			linkedList.add("0" + i);
		}
		System.out.println("LinkedList: " + linkedList);

		Set<String> hashSet = new HashSet<String>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			hashSet.add("0" + i);
		}
		System.out.println("HashSet: " + hashSet);

		Map<String, Integer> hashMap = new HashMap<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			hashMap.put("Key0" + i, i);
		}
		System.out.println("HashMap: " + hashMap);
	}
}
