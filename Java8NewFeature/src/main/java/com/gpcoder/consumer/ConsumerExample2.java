package com.gpcoder.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Programing {
	public String language;
	public int experience;

	public Programing(String language, int experience) {
		this.language = language;
		this.experience = experience;
	}

	public void print() {
		System.out.println("Language: " + language + " - Experience: " + experience);
	}
}

public class ConsumerExample2 {

	public static void main(String[] args) {

		List<Programing> list = new ArrayList<>();
		list.add(new Programing("Java", 5));
		list.add(new Programing("PHP", 2));
		list.add(new Programing("C#", 1));

		// Creating instance of Consumer functional interface
		Consumer<Programing> consumer = (p) -> System.out.println(
				"Name: " + p.language + " - Experience: " + p.experience);

		System.out.println("Using Consumer: ");
		list.forEach(consumer);

		System.out.println("\nUsing Method Reference: ");
		list.forEach(Programing::print);

		System.out.println("\nUsing Lambda Expression: ");
		list.forEach(s -> s.print());
	}
}
