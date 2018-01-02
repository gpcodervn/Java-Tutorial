package com.gpcoder.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample3 {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Create list
		List<Student> students = new LinkedList<>();
		for (int i = 1; i <= NUM_OF_ELEMENT; i++) {
			// Add element to list
			Student student = new Student(i, "myname" + i);
			students.add(student);
		}

		// Show list student
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
