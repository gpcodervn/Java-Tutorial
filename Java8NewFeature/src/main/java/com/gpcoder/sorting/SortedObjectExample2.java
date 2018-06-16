package com.gpcoder.sorting;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortedObjectExample2 {

	public static void main(String[] args) {

		Student []students = { //
				new Student(1, "One", 22), //
				new Student(2, "Two", 18), //
				new Student(3, "Three", 20), //
				new Student(4, "Four", 19), //
				new Student(5, "Five", 22) //
		};

		Arrays.sort(students);
		Stream.of(students).forEach(System.out::println);
	}
}
