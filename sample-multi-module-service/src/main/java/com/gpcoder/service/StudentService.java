package com.gpcoder.service;

import java.util.ArrayList;
import java.util.List;

import com.gpcoder.model.Student;

public class StudentService {

	public static List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		for (int i = 1; i <= 5; i++) {
			students.add(new Student(i, "Student " + i));
		}
		return students;
	}

}
