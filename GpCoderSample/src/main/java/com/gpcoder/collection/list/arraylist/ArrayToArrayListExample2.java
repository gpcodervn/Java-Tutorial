package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayToArrayListExample2 {
	public static void main(String[] args) {
		// Array Declaration and initialization
		String[] arr = { "JAVA", "J2EE", "JSP", "SERVLETS" };

		// ArrayList declaration
		ArrayList<String> list = new ArrayList<String>();

		// Array to ArrayList conversion
		Collections.addAll(list, arr);

		// Adding new elements to the converted List
		list.add("C#");
		list.add("PHP");

		// Print list data
		System.out.println(list); // [JAVA, J2EE, JSP, SERVLETS, C#, PHP]
	}
}
