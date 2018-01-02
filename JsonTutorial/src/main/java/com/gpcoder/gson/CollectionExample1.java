package com.gpcoder.gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CollectionExample1 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		List<Integer> ints = Arrays.asList(1,2,3,4,5);

		// Serialization
		String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

		// Deserialization
		Type collectionType = new TypeToken<List<Integer>>(){}.getType();
		Collection<Integer> ints2 = gson.fromJson(json, collectionType);
		// ==> ints2 is same as ints
	}
}
