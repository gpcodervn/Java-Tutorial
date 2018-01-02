package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateInArrayList1 {
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

		// Constructing Another ArrayList
		List<String> listWithoutDuplicateElements = new ArrayList<String>();
		for (String element : listWithDuplicateElements) {
			// Check if element not exist in list, perform add element to list
			if (!listWithoutDuplicateElements.contains(element)) {
				listWithoutDuplicateElements.add(element);
			}
		}

		// Printing listWithoutDuplicateElements
		System.out.println("\nArrayList After Removing Duplicate Elements :");
		System.out.println(listWithoutDuplicateElements);
	}
}
