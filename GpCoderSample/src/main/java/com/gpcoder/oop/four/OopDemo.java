package com.gpcoder.oop.four;

public class OopDemo {
	
	public static void main(String[] args) {
		Animal cat = new Cat("Tom");
		cat.sayHello();
		System.out.println("---");
		Animal dog = new Dog("Milu");
		dog.sayHello();
	}
	
}
