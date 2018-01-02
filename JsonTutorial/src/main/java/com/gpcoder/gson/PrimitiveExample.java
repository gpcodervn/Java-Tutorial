package com.gpcoder.gson;

import com.google.gson.Gson;

public class PrimitiveExample {
	public static void main(String[] args) {
		// Serialization
		Gson gson = new Gson();
		gson.toJson(1); // ==> 1
		gson.toJson("abcd"); // ==> "abcd"
		gson.toJson(new Long(10)); // ==> 10
		int[] values = { 1 };
		gson.toJson(values); // ==> [1]

		// Deserialization
		int one = gson.fromJson("1", int.class);// ==> 1
		Integer oneInteger = gson.fromJson("1", Integer.class);// ==> 1
		Long oneLong = gson.fromJson("1", Long.class);// ==> 1
		Boolean bool = gson.fromJson("false", Boolean.class); // ==> false
		String str = gson.fromJson("\"abc\"", String.class);// ==> "abcd"
		String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);// ==> ["abc"]
	}
}
