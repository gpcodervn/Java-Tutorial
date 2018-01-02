package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateInArrayList3 {
	public static void main(String[] args) {
		// Constructing An ArrayList
		List<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");

		// Printing listWithDuplicateElements
		System.out.println("ArrayList With Duplicate Elements :");
		System.out.println(listWithDuplicateElements);

		// Constructing LinkedHashSet using listWithDuplicateElements
		Set<String> set = new LinkedHashSet<String>(listWithDuplicateElements);

		// Constructing listWithoutDuplicateElements using set
		List<String> listWithoutDuplicateElements = new ArrayList<String>(set);

		// Printing listWithoutDuplicateElements
		System.out.println("\nArrayList After Removing Duplicate Elements :");
		System.out.println(listWithoutDuplicateElements);
	}
}
