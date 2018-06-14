package com.gpcoder.collectors;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {

	private String name;
	private Integer score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}
}

public class CollectorsExample2 {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList( //
				new Student("B", 70), //
				new Student("A", 80), //
				new Student("C", 75), //
				new Student("A", 100) //
		);

		// Resolve collisions between values associated with the same key
		Map<String, Integer> result1 = students.stream().collect( //
				Collectors.toMap(Student::getName, Student::getScore, //
						(s1, s2) -> (s1 > s2 ? s1 : s2) // BinaryOperator
				));
		System.out.println("result1 : " + result1);

		// Identify the instance of LinkedHashMap
		Map<String, Integer> result2 = students.stream().collect( //
				Collectors.toMap(Student::getName, Student::getScore, //
						(s1, s2) -> (s1 > s2 ? s1 : s2), // BinaryOperator
						LinkedHashMap::new // Supplier
				));
		System.out.println("result2 : " + result2);
	}
}
