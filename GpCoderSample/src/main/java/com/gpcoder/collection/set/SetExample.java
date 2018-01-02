package com.gpcoder.collection.set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
	public static void main(String[] args) {
		// Create set
		Set<String> set = new HashSet<>();
		set.add("A02");
		set.add("D03");
		set.add("D03");
		set.add("01");
		set.add("04");

		// Show set through for-each
		for (String item : set) {
			System.out.print(item + " ");
		}
	}
}
