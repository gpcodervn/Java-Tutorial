package com.gpcoder.oop.interfacedemo.multiple;

public class Rectangle implements Shape, Color {

	@Override
	public void draw() {
		System.out.println("Draw " + this.getColor() + " rectangle");
	}

	@Override
	public String getColor() {
		return "red";
	}
	
}
