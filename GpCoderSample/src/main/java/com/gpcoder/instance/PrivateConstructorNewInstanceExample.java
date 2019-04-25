package com.gpcoder.instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PrivateConstructorNewInstanceExample {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// Get class based on the given class name
		Class<?> clazz = Class.forName("com.gpcoder.instance.PrivateEmployee");
		
		// Get the private constructor.
		Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class);
		
		// Since it is private, make it accessible.
		constructor.setAccessible(true);

		// Create a new instance with specific constructor of class
		PrivateEmployee employee = (PrivateEmployee) constructor.newInstance(1, "gpcoder");
		System.out.println("employee: " + employee);
	}
}
