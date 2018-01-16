package com.gpcoder.jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.jackson.object.Student;
import com.gpcoder.jackson.object.Subject;

public class ArrayExample {
	public static void main(String[] args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		Student student1 = getStudent(1);
		Student student2 = getStudent(2);

		Student[] students = { student1, student2 };

		// Convert array object to JSON string
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
		System.out.println("JSON: " + jsonInString);

		// Convert a JSON Array format to a Java List object
		List<Student> list = mapper.readValue(jsonInString, new TypeReference<List<Student>>() {
		});
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private static Student getStudent(int id) {
		Subject math = new Subject("Math", 10.0f);
		Subject physical = new Subject("Physical", 8.5f);
		List<Subject> subjects = new ArrayList<>();
		subjects.add(math);
		subjects.add(physical);

		return new Student("GP Coder " + id, 28, subjects);
	}
}
