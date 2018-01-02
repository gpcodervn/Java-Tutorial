package com.gpcoder.collection.list.vector;

import java.util.Enumeration;
import java.util.Vector;

public class VectorEnumerationExample {
	public static void main(String args[]) {
		// creating vector
		Vector<String> vector = new Vector<String>();

		// adding object in vector
		vector.add("Sonoo");// method of Collection
		vector.addElement("Michael");// method of Vector
		vector.addElement("James");
		vector.add("Andy");

		// traversing elements using Enumeration
		Enumeration<String> e = vector.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
