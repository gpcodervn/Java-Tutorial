package com.gpcoder.instance;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		Programer obj1 = new Programer(1, "gpcoder");
		Programer obj2 = obj1.clone();
		obj2.setName(obj2.getName().toUpperCase());
		
		System.out.println(obj1);
		System.out.println(obj2);
	}
}
