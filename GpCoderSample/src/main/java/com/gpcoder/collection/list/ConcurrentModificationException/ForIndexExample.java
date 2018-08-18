package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.List;

public class ForIndexExample {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		for (int i = 0; i < languages.size(); i++) {
		    String language = languages.get(i);
		    if (language.equals("Ruby")) {
		        languages.remove(language);
		    }
		    System.out.println(languages.get(i)); // IndexOutOfBoundsException
		}
	}
}
