package com.gpcoder.jackson.object;

import java.util.List;

public class Student {
	private String name;
	private int age;
	private List<Subject> subjects;

	public Student() {
		super();
	}

	public Student(String name, int age, List<Subject> subjects) {
		super();
		this.name = name;
		this.age = age;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", subjects=" + subjects + "]";
	}
}
