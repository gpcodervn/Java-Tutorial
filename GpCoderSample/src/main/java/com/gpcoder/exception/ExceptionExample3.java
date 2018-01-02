package com.gpcoder.exception;

import com.gpcoder.oop.Dog;
import com.gpcoder.oop.abstractdemo.Rectangle;

public class ExceptionExample3 {

	public static void main(String[] args) {

		Object dog = new Dog();
		Rectangle rect = (Rectangle) dog;
	}

}
