package com.gpcoder.collection.set.treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample3 {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Create list
		Set<Student> students = new TreeSet<>();
		Student student1 = new Student(1, "myname1");
		Student student2 = new Student(2, "myname2");
		Student student3 = new Student(3, "myname3");
		Student student4 = new Student(4, "myname4");
		Student student5 = new Student(5, "myname5");
		students.add(student1);
		students.add(student3);
		students.add(student2);
		students.add(student5);
		students.add(student4);
		students.add(student2);
		students.add(student3);

		// Show set student
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
