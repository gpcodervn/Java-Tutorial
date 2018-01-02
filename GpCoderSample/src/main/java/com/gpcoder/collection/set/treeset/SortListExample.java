package com.gpcoder.collection.set.treeset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListExample {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Create list
		List<Student> students = new ArrayList<>();
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

		// Show list student
		System.out.println("List without sorted: ");
		printData(students);
		System.out.println("--- ");

		System.out.println("List sorted using Comparable: ");
		List<Student> students2 = new ArrayList<>(students);
		Collections.sort(students2, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// sort student's name by ASC
				return o1.getName().compareTo(o2.getName());
			}
		});
		printData(students2);
		System.out.println("--- ");

		System.out.println("List sorted using Comparable: ");
		List<Student> students3 = new ArrayList<>(students);
		Collections.sort(students3, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// sort student's id by DESC
				return o2.getName().compareTo(o1.getName());
			}
		});
		printData(students3);
		System.out.println("--- ");
	}

	public static void printData(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
