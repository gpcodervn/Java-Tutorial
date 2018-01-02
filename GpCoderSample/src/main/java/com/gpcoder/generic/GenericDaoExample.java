package com.gpcoder.generic;

public class GenericDaoExample {

	public static void main(String[] args) {
		Student student = new Student(1, "gpcoder", 28);
		StudentDao dao = new StudentDao();
		dao.insert(student);
	}
}
