package com.gpcoder.supplier;

import java.util.function.Supplier;

class Programing {
	public String language;
	public int experience;

	public Programing() {
		this.language = "Java";
		this.experience = 5;
	}

	public Programing(String language, int experience) {
		this.language = language;
		this.experience = experience;
	}

	public void print() {
		System.out.println("Language: " + language + " - Experience: " + experience);
	}

	public static String getDefaulLanguage() {
		return "Java";
	}
}

public class SupplierExample2 {

	public static void main(String[] args) {

		Supplier<Programing> supplier1 = Programing::new;
		Programing lang = supplier1.get();
		lang.print();

		Supplier<String> supplier2 = Programing::getDefaulLanguage;
		String defaultLang = supplier2.get();
		System.out.println("Default Language: " + defaultLang);
	}
}
