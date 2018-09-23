package com.gpcoder.remove_duplicate;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateInArrayList2 {

	public static void main(String[] args) {
		List<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLETS");
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");

		Set<String> elementsAlreadySeen = new LinkedHashSet<>();
		listWithDuplicateElements.removeIf(s -> !elementsAlreadySeen.add(s));
		System.out.println(elementsAlreadySeen); // [JAVA, J2EE, JSP, SERVLETS, STRUTS]
	}
}
