package com.gpcoder.jackson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.jackson.object.Student;

public class Json2ObjectExample {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		// Convert JSON string from file to Object
		Student student = mapper.readValue(new File("data/result.json"), Student.class);
		System.out.println(student);

		// Convert JSON string to Object
		String jsonInString = "{\"name\":\"GP Coder\",\"age\":28,\"subjects\":[{\"name\":\"Math\",\"point\":10.0},{\"name\":\"Physical\",\"point\":8.0}]}";
		student = mapper.readValue(jsonInString, Student.class);
		System.out.println(student);

		// Pretty print
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
		System.out.println(jsonInString);
	}
}
