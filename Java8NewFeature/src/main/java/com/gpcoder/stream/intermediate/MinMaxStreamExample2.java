package com.gpcoder.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Programing {
	private String name;
	private int exp;

	public Programing(String name, int age) {
		super();
		this.name = name;
		this.exp = age;
	}

	public String getName() {
		return name;
	}

	public int getExp() {
		return exp;
	}
}

public class MinMaxStreamExample2 {

	public static void main(String[] args) {

		List<Programing> students = Arrays.asList( //
				new Programing("Java", 5), //
				new Programing("PHP", 2), //
				new Programing("C#", 1) //
		);

		// Max = 5
		Programing maxByExp = students.stream()
				.max(Comparator.comparing(Programing::getExp))
				.get();
		
		// Min = 1
		Programing minByExp = students.stream()
				.min(Comparator.comparing(Programing::getExp))
				.get();
	}
}
