package com.gpcoder.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortedObjectExample4 {

	public static void main(String[] args) {

		Student []students = { //
				new Student(1, "One", 22), //
				new Student(2, "Two", 18), //
				new Student(3, "Three", 20), //
				new Student(4, "Four", 19), //
				new Student(5, "Five", 22) //
		};

		Comparator<Student> nameComparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};

		Arrays.sort(students, nameComparator);
		Stream.of(students).forEach(System.out::println);
	}
}
