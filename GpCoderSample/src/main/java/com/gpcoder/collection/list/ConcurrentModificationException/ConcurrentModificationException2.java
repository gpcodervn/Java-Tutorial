package com.gpcoder.collection.list.ConcurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException2 {

	public static void main(String[] args) {
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("C#");
		languages.add("PHP");
		languages.add("C++");
		languages.add("Ruby");

		Iterator<String> iterator = languages.iterator();
		while (iterator.hasNext()) {
			String language = iterator.next();
			if (language.equals("C#")) {
				languages.remove(language);
			}
		}
	}
}
