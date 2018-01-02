package com.gpcoder.oop;

public class Student extends Person {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.println("id = " + id + ", name = " + name);
	}

	public void printChild1() {
		this.print();
	}

	public void printChild2() {
		super.print();
	}

	public static void main(String args[]) {
		Student student = new Student(1, "gpcoder");
		student.print();
		System.out.println("---");
		student.printChild1();
		System.out.println("---");
		student.printChild2();
	}

}