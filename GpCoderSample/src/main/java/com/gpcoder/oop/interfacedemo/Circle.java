package com.gpcoder.oop.interfacedemo;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw " + color + " circle");
	}
	
}
