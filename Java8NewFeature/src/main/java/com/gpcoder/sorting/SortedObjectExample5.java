package com.gpcoder.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedObjectExample5 {

	public static void main(String[] args) {

		List<Student> students = Arrays.asList( //
				new Student(1, "One", 22), //
				new Student(2, "Two", 18), //
				new Student(3, "Three", 20), //
				new Student(4, "Four", 19), //
				new Student(5, "Five", 22) //
		);

		Collections.sort(students, Helper::compareByAge);

		// Or
		students.sort(Helper::compareByAge);

		students.forEach(System.out::println);
	}
}
