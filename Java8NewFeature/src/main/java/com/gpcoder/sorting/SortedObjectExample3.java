package com.gpcoder.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedObjectExample3 {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList( //
				new Student(1, "One", 22), //
				new Student(2, "Two", 18), //
				new Student(3, "Three", 20), //
				new Student(4, "Four", 19), //
				new Student(5, "Five", 22) //
		);

		// Anonymous function
		Comparator<Student> nameComparator1 = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
		Collections.sort(students, nameComparator1);

		// Lambda
		Comparator<Student> nameComparator2 = (s1, s2) -> s1.getName().compareTo(s2.getName());
		Collections.sort(students, nameComparator2);

		students.forEach(System.out::println);
	}

	// Inner class
	class NameComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getName().compareTo(s2.getName());
		}
	}
}
