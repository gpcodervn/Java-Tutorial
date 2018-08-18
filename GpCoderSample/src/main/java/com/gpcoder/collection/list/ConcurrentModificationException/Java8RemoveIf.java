package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

public class Java8RemoveIf {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		languages.removeIf(language -> language.equals("C#") || language.equals("Ruby"));
		System.out.println(languages); // [Java, PHP, C++]
	}
}
