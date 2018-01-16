package com.gpcoder.jackson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.jackson.object.Student;
import com.gpcoder.jackson.object.Subject;

public class Object2JsonExample {
	public static void main(String[] args) throws Exception {
		Student student = getStudent();

		ObjectMapper mapper = new ObjectMapper();

		// Convert object to JSON string and save into a file directly
		mapper.writeValue(new File("data/result.json"), student); // Plain JSON

		// Convert object to JSON string
		String jsonInString = mapper.writeValueAsString(student);
		System.out.println("JSON: " + jsonInString);

		// Convert object to JSON string and pretty print
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		System.out.println("JSON pretty print: " + jsonInString);
	}

	private static Student getStudent() {
		Subject math = new Subject("Math", 10.0f);
		Subject physical = new Subject("Physical", 8.5f);
		List<Subject> subjects = new ArrayList<>();
		subjects.add(math);
		subjects.add(physical);

		return new Student("GP Coder", 28, subjects);
	}
}
