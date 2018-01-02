package com.gpcoder.collection.list.vector;

import java.util.List;
import java.util.Vector;

class Student {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}

public class VectorExample {
	public static final int NUM_OF_ELEMENT = 5;

	public static void main(String[] args) {
		// Create list with compacity = 3
		List<Student> students = new Vector<>(3);
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
