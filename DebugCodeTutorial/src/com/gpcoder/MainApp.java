package com.gpcoder;

public class MainApp {

	public static void main(String[] args) {
		Student student = new Student(1, "GP Coder");
		String hello = sayHello(student);
		System.out.println(hello);
	}

	public static String sayHello(Student student) {
		return "Hello " + student.getName();
	}

	public static void checkStudent(Integer id) {
		if (id != null) {
			System.out.printf("Valid");
		} else {
			System.out.printf("Invalid");
		}
	}
}
