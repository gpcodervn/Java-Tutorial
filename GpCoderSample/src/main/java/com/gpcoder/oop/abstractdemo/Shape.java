package com.gpcoder.oop.abstractdemo;

public abstract class Shape {
	private String color = "red";
	
	public Shape() {
		
	}
	
	protected abstract void draw();
	
	public String getColor() {
		return color;
	}
}
