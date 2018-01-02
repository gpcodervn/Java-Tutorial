package com.gpcoder.collection.set.treeset;

public class Student2 implements Comparable<Student2> {
	private int id;
	private String name;

	public Student2(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student2 student) {
		// sort student's name by ASC
		return this.getName().compareTo(student.getName());
	}

	public String getName() {
		return name;
	}
}
