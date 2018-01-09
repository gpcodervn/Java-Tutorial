package com.gpcoder.gson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.google.gson.stream.JsonWriter;

public class GsonStreamingWriterExample {
	public static void main(String args[]) throws IOException {
		OutputStream out = new FileOutputStream("data/result.json");
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

		writer.beginObject(); // {
		writer.name("name").value("GP Coder"); // "name" : "gpcoder"
		writer.name("website").value("https://gpcoder.com"); // "website" : "https://gpcoder.com"
		writer.name("year").value(2017); // "year" : 2017

		writer.name("posts"); // "colors" :
		writer.beginArray(); // [
		writer.value("Java Core"); // "Java Core"
		writer.value("Design Pattern"); // "Design Pattern"
		writer.value("Spring"); // "Spring"
		writer.endArray(); // ]

		writer.endObject(); // }
		writer.close();

		System.out.println("Done!");
	}
}
