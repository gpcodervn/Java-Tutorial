package com.gpcoder.oop.abstractdemo;

public class Circle extends Shape {

	@Override
	public void draw() {
		System.out.println("Draw " + super.getColor() + " circle");
	}
	
}
