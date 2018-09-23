package com.gpcoder.remove_duplicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student {
	private String name;
	private String email;

	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
}

public class RemoveDuplicateInArrayList3 {

	public static void main(String[] args) {
		List<Student> studentsWithtDuplicate = new ArrayList<>();
		studentsWithtDuplicate.add(new Student("Nguyen Nhat", "nguyennhat@gmail.com"));
		studentsWithtDuplicate.add(new Student("Le Van", "levan@gmail.com"));
		studentsWithtDuplicate.add(new Student("Tran Khoa", "trankhoa@gmail.com"));
		studentsWithtDuplicate.add(new Student("Le Vo", "levan@gmail.com"));
		studentsWithtDuplicate.add(new Student("Ly Nguyen", "lynguyen@gmail.com"));

		Set<Student> studentsWithoutDuplicate = studentsWithtDuplicate.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getEmail))));
		studentsWithoutDuplicate.forEach(s -> System.out.println(s));
	}
}
