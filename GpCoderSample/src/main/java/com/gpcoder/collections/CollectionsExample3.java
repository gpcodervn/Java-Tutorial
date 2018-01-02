package com.gpcoder.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsExample3 {
	public static void main(String a[]) {
		// Create list
		List<Student> students = new ArrayList<>();
		Student student1 = new Student(1, "myname1", 15);
		Student student2 = new Student(2, "myname2", 20);
		Student student3 = new Student(3, "myname3", 17);
		Student student4 = new Student(4, "myname4", 10);
		Student student5 = new Student(5, "myname5", 19);
		Student student6 = new Student(6, "myname6", 19);
		students.add(student3);
		students.add(student1);
		students.add(student2);
		students.add(student5);
		students.add(student4);

		// Init comparator
		StudentAgeComparator ageComparator = new StudentAgeComparator();

		// Using comparator
		System.out.println("Maximum value: " + Collections.max(students, ageComparator));
		System.out.println("Minimum value: " + Collections.min(students, ageComparator));
		System.out.println("Index of student1 : " + Collections.binarySearch(students, student1, ageComparator));
		System.out.println("Index of student6 : " + Collections.binarySearch(students, student6, ageComparator));
		System.out.println("---");

		Collections.sort(students, ageComparator);
		System.out.println("Sorted ASC: ");
		print(students);

		Collections.reverse(students);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student> compareDesc = Collections.reverseOrder(ageComparator);
		Collections.sort(students, compareDesc);
		System.out.println("Sorted DESC: ");
		print(students);

		Comparator<Student> compareAsc = Collections.reverseOrder(compareDesc);
		Collections.sort(students, compareAsc);
		System.out.println("Sorted ASC: ");
		print(students);
	}

	private static void print(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println("---");
	}
}
