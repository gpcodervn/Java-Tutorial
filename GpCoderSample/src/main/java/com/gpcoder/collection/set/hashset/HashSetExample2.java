package com.gpcoder.collection.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Create set
		Set<String> set = new HashSet<>();
		set.add("Item01");
		set.add("Item02");
		set.add("Item03");
		set.add("Item04");
		set.add("Item05");
		set.add("Item02");
		set.add("Item03");

		// Show set through for-each
		for (String item : set) {
			System.out.print(item + " ");
		}
	}
}
