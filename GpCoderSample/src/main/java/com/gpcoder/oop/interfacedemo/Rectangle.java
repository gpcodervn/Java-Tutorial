package com.gpcoder.oop.interfacedemo;

public class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Draw " + color + " rectangle");
	}
	
}
