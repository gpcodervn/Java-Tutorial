package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException1 {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		// Using forEach loop to iterate and add/ removing element during iteration will
		// throw ConcurrentModificationException in Java
		for (String language : languages) {
			if (language.equals("C#")) {
				languages.remove(language);
			}
		}
	}
}
