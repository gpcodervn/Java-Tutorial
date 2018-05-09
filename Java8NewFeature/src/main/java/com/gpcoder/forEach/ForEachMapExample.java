package com.gpcoder.forEach;

import java.util.HashMap;
import java.util.Map;

public class ForEachMapExample {

	public static void main(String[] args) {
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "Java");
		hmap.put(2, "Javascript");
		hmap.put(3, "PHP");
		hmap.put(4, "C#");
		hmap.put(5, "C++");

		// forEach to iterate and display each key and value pair of HashMap
		hmap.forEach((key, value) -> System.out.println(key + " - " + value));
	}
}
