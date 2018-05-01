package com.gpcoder.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortJava8Example {

	public static void main(String[] args) {

		List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

//		Collections.sort(languages, (String o1, String o2) -> {
//			return o1.compareTo(o2);
//		});
		
//		Collections.sort(languages, (String o1, String o2) -> o1.compareTo(o2)  );
		
		Collections.sort(languages, (o1, o2) -> o1.compareTo(o2));

		for (String language : languages) {
			System.out.println(language);
		}
	}
}
