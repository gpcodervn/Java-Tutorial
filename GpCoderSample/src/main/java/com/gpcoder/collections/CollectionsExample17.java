package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class CollectionsExample17 {
	public static void main(String args[]) {
		Vector<Integer> vect = new Vector<>();
		vect.addElement(10);
		vect.addElement(30);
		vect.add(50);
		vect.add(20);
		System.out.println("Elements of Vector: " + vect);

		Enumeration<Integer> e = vect.elements();
		ArrayList<Integer> myList = Collections.list(e);
		System.out.println("Elements of ArrayList: " + myList);
	}
}
