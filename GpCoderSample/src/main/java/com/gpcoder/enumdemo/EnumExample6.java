package com.gpcoder.enumdemo;

import java.util.Arrays;

interface Option {
	int getValue();

	String getLabel();
}

enum Gender implements Option {
	MALE(1, "Male"), FEMALE(2, "Female");

	private int value;
	private String label;

	private Gender(int value, String label) {
		this.value = value;
		this.label = label;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}
}

enum Country implements Option {
	VIETNAM(1, "Viet Nam"), ENGLAND(2, "England");

	private int value;
	private String label;

	private Country(int value, String label) {
		this.value = value;
		this.label = label;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}
}

public class EnumExample6 {
	public static void main(String[] args) {
		Option[] countries = Country.values();
		Option[] genders = Gender.values();

		System.out.println(Arrays.asList(countries));
		System.out.println(Arrays.asList(genders));
	}
}
