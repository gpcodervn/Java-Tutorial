package com.gpcoder.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JacksonStreamingWriterExample {
	public static void main(String args[]) throws IOException {
		File file = new File("data/result.json");

		JsonFactory factory = new JsonFactory();

		/**
		 * Write values in JSON format to a file
		 */
		JsonGenerator generator = factory.createGenerator(file, JsonEncoding.UTF8);

		generator.writeStartObject(); // {
		generator.writeStringField("name", "GP Coder"); // "name" : "gpcoder"
		generator.writeStringField("website", "https://gpcoder.com"); // "website" : "https://gpcoder.com"
		generator.writeNumberField("year", 2017); // "year" : 2017

		generator.writeFieldName("posts"); // "colors" :
		generator.writeStartArray(); // [
		generator.writeString("Java Core"); // "Java Core"
		generator.writeString("Design Pattern"); // "Design Pattern"
		generator.writeString("Spring"); // "Spring"
		generator.writeEndArray(); // ]

		generator.writeEndObject(); // }
		generator.close();

		System.out.println("Done!");
	}
}
