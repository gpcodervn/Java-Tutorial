package com.gpcoder.forEach;

import java.util.Arrays;
import java.util.List;

public interface ForEachListExample {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		System.out.println("Iterating by passing lambda expression: ");
		languages.forEach(lang -> System.out.println(lang));

		System.out.println("Iterating by passing method reference: ");
		languages.forEach(System.out::println);
	}
}
