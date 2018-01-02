package com.gpcoder.inheritance;

public class Downcating {

	public static void main(String[] args) {
		Animal animal = new Cat();
		Cat cat = (Cat) animal;
		cat.meow();
	}

}
