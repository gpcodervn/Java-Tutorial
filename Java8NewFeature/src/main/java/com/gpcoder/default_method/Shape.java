package com.gpcoder.default_method;

public interface Shape {

	void draw();

	default void setColor(String color) {
		System.out.println("Draw shape with color " + color);
	}
}
