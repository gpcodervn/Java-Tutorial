package com.gpcoder.collection.set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample3 {
	public static void main(String[] args) {
		// Create list
		Set<Student> students = new LinkedHashSet<>();
		// Add element to list
		Student student1 = new Student(1, "myname1");
		Student student2 = new Student(2, "myname2");
		Student student3 = new Student(3, "myname3");
		students.add(student1);
		students.add(student2);
		students.add(student3);

		// Show list student
		Iterator<Student> it = students.iterator();
		students.remove(student2); // You will get ConcurrentModificationException
							// if they are modified after the creation of Iterator object.
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s);
		}
	}
}
