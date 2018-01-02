package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExample {
	public static void main(String a[]) {
		// Using empty fields
		List<Integer> list1 = Collections.EMPTY_LIST;
		Set<Integer> set1 = Collections.EMPTY_SET;
		Map<Integer, String> map1 = Collections.EMPTY_MAP;

		// Can't add element
		// list1.add(10); // throw UnsupportedOperationException
		// set1.add(10); // throw UnsupportedOperationException
		// map1.put(1, "one"); // throw UnsupportedOperationException

		// Using empty methods
		List<Integer> list2 = Collections.emptyList();
		Set<Integer> set2 = Collections.emptySet();
		Map<Integer, String> map2 = Collections.emptyMap();

		// Can't add element
		// list2.add(10); // throw UnsupportedOperationException
		// set2.add(10); // throw UnsupportedOperationException
		// map2.put(1, "one"); // throw UnsupportedOperationException
		
		// After init
		list2 = new ArrayList<>();
		list2.add(1); // run normally
	}
}
