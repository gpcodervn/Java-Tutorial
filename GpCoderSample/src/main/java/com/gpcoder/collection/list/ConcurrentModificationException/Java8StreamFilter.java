package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamFilter {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		List<String> removedList = languages.stream()
				.filter(language -> language.equals("C#") || language.equals("Ruby"))
				.collect(Collectors.toList());
	}
}
