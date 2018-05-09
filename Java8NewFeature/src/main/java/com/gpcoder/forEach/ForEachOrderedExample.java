package com.gpcoder.forEach;

import java.util.Arrays;
import java.util.List;

public class ForEachOrderedExample {

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

		System.out.println("Iterating by passing lambda expression: ");
		languages.stream().forEachOrdered(lang -> System.out.println(lang));

		System.out.println("Iterating by passing method reference: ");
		languages.stream().forEachOrdered(System.out::println);
	}
}
