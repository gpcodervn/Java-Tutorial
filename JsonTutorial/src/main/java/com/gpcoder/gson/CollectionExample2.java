package com.gpcoder.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class CollectionExample2 {
	public static void main(String[] args) {
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("GP Coder", "Viet Nam"));
		persons.add(new Person("Vincent", "Canada"));

		// Serialization
		String json = gson.toJson(persons);  
		System.out.println(json);

		// Deserialization
		Type collectionType = new TypeToken<List<Person>>(){}.getType();
		List<Person> persons2 = gson.fromJson(json, collectionType);
		// ==> persons2 is same as persons
	}
}

