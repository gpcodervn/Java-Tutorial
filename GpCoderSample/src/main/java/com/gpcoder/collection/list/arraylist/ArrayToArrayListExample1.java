package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayToArrayListExample1 {
	public static void main(String[] args) {
		// Array Declaration and initialization
		String[] arr = { "JAVA", "J2EE", "JSP", "SERVLETS" };

		// Array to ArrayList conversion
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(arr));

		// Adding new elements to the converted List
		list.add("C#");
		list.add("PHP");

		// Print list data
		System.out.println(list); // [JAVA, J2EE, JSP, SERVLETS, C#, PHP]
	}
}
