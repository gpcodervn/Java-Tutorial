package com.gpcoder.sorting;

public class Student implements Comparable<Student> {

	private int id;
	private String name;
	private int age;

	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Student s) {
		return this.getName().compareTo(s.getName());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
