package com.gpcoder;

public class IfElseShorthand {

	public static void main(String[] args) {
		boolean isEven;
		if (4 % 2 == 0) {
			isEven = true;
		} else {
			isEven = false;
		}
		System.out.println(isEven); // true
		
		isEven = (4 % 2 == 0) ? true : false;
		System.out.println(isEven); // true
		
		isEven = (5 % 2 == 0) ? true : false;
		System.out.println(isEven); // false
	}
}
