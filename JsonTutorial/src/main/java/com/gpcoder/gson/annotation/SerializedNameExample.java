package com.gpcoder.gson.annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.Student;

public class SerializedNameExample {

	public static void main(String[] args) {
		final GsonBuilder builder = new GsonBuilder();
	    final Gson gson = builder.create();

	    final Student student = new Student(1, "GP Coder", "Java Dev");

	    final String json = gson.toJson(student);
	    System.out.println("Json: " + json);
 
	    final Student student2 = gson.fromJson(json, Student.class);
	    System.out.println("Java Object: " + student2);
	}
	
}
