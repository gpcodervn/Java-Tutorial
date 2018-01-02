package com.gpcoder.oop;

import com.gpcoder.oop.abstractdemo.Rectangle;

public class Dog extends Animal {
	public static void main(String[] args) {
		Dog dog = new Dog();
        System.out.println(dog instanceof Dog); // true
        System.out.println(dog instanceof Animal); // true
	}
}
