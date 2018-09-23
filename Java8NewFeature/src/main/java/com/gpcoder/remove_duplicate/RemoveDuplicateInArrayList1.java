package com.gpcoder.remove_duplicate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateInArrayList1 {

	public static void main(String[] args) {
		List<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");

		List<String> listWithoutDuplicateElements = listWithDuplicateElements
				.stream()
				.distinct() 
				.collect(Collectors.toList());
		System.out.println(listWithoutDuplicateElements); // [JAVA, J2EE, JSP, SERVLETS, STRUTS]
	}
}
