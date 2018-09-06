package com.gpcoder.objectcloning;

import javax.swing.text.DefaultEditorKit.CopyAction;

class Student {
	int id;
	String name;

	Student() {

	}

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void show() {
		System.out.println("Student [id=" + id + ", name=" + name + "]");
	}
}

public class ObjectCloningExample1 {

	public static void main(String[] args) {
		// copy();
		cloning();
	}

	private static void copy() {
		Student s1 = new Student(1, "GP Coder");
		Student s2 = s1;
		s1.show();
		s2.show();

		System.out.println("s1 and s2 are the same reference: ");
		System.out.println(s1);
		System.out.println(s2);

		System.out.println("After changed: ");
		s1.id = 4;
		s1.show();
		s2.show();
	}

	private static void cloning() {
		Student s1 = new Student(1, "GP Coder");
		Student s2 = new Student();
		s2.id = s1.id;
		s2.name = s1.name;
		s1.show();
		s2.show();

		System.out.println("s1 and s2 are the different reference: ");
		System.out.println(s1);
		System.out.println(s2);

		System.out.println("After changed: ");
		s1.id = 4;
		s1.show();
		s2.show();
	}
}
