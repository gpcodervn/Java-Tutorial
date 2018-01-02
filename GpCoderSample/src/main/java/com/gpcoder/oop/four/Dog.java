package com.gpcoder.oop.four;

public class Dog extends Animal {
	
	public Dog(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, I'm " + super.getName());
	}
	
}
