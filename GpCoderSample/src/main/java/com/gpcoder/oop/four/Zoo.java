package com.gpcoder.oop.four;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

	private List<Animal> animals = new ArrayList<Animal>();
	
	public void add(Animal animal) {
		animals.add(animal);
	}
	
	public void remove(Animal animal) {
		animals.remove(animal);
	}
	
	public void showListAnimal() {
		for (Animal animal : animals) {
			animal.sayHello();
		}
	}
	
}
