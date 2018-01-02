package com.gpcoder.oop.interfacedemo.multiple;

public class Circle implements ShapeColor {

	@Override
	public void draw() {
		System.out.println("Draw " + this.getColor() + " circle");
	}

	@Override
	public String getColor() {
		return "red";
	}
	
}
