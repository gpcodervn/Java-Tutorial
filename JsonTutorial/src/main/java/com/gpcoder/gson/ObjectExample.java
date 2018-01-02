package com.gpcoder.gson;

import com.google.gson.Gson;

class Person {
	private String name;
	private String location;

	public Person(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", location=" + location + "]";
	}

	// Getters and setters are not required for this example.
	// GSON sets the fields directly using reflection.
}

public class ObjectExample {

	public static void main(String[] args) {
		Person person = new Person("GP Coder", "Viet Nam");
		Gson gson = new Gson();
		// Serialization
		String json = gson.toJson(person);
		System.out.println(json); // {"name":"GP Coder","location":"Viet Nam"}
		
		// Deserialization
        Person person2 = gson.fromJson(json, Person.class);
        System.out.println(person2);
	}
}
