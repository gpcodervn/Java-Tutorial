package com.gpcoder.enumdemo;

public class EnumExample {
	public static void main(String[] args) {
		for (Color color : Color.values()) {
			System.out.println(color.getName() + " = " + color.getHexCode());
		}
	}
}