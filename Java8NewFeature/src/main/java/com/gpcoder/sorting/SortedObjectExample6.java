package com.gpcoder.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedObjectExample6 {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList( //
				new Student(1, "One", 22), //
				new Student(2, "Two", 18), //
				new Student(3, "Three", 20), //
				new Student(4, "Four", 19), //
				new Student(5, "Five", 22) //
		);

		preJava8(students);
		java8(students);
	}

	private static void preJava8(List<Student> students) {
		Comparator<Student> comparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if (s1.getAge() == s2.getAge()) {
					return s1.getName().compareTo(s2.getName());
				}
				return s1.getAge() - s2.getAge();
			}
		};

		Collections.sort(students, comparator);
		System.out.println("PreJava8: ");
		students.forEach(System.out::println);
	}

	private static void java8(List<Student> students) {
		Comparator<Student> comparator = Comparator.comparing(Student::getAge).thenComparing(Student::getName);

		Collections.sort(students, comparator);
		// Or
		students.sort(comparator);

		System.out.println("\nJava8: ");
		students.forEach(System.out::println);
	}
}
