package com.gpcoder.oop.four;

public class OopDemo2 {
	
	public static void main(String[] args) {
		Cat cat = new Cat("Tom");
		Dog dog = new Dog("Milu");
		
		Zoo zoo = new Zoo();
		zoo.add(cat);
		zoo.add(dog);
		zoo.showListAnimal();
	}
	
}
