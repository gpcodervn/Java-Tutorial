package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		List<String> toRemove = new ArrayList<>();
		for (String language : languages) {
			if (language.equals("C#") || language.equals("Ruby")) {
				toRemove.add(language);
			}
		}
		languages.removeAll(toRemove);
		System.out.println(languages); // [Java, PHP, C++]
	}
}
