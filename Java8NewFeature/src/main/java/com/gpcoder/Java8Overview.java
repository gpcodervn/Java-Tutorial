package com.gpcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Overview {
	public static void main(String[] args) {
		List<String> list1 = createDummyData();
		List<String> list2 = createDummyData();

		// Sort using Java 7 syntax
		sortUsingJava7(list1);
		System.out.println(list1);

		// Sort using Java 8 syntax
		sortUsingJava8(list2);
		System.out.println(list2);

	}

	// sort using java 7
	private static void sortUsingJava7(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private static void sortUsingJava8(List<String> list) {
		Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
	}

	private static List<String> createDummyData() {
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("C++");
		list.add("C#");
		list.add("PHP");
		list.add("Javascript");
		return list;
	}
}
