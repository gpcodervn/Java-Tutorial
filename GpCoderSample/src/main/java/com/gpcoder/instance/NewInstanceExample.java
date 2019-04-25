package com.gpcoder.instance;

import java.lang.reflect.InvocationTargetException;

public class NewInstanceExample {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		// Get class based on the given class name
		Class<?> clazz = Class.forName("com.gpcoder.instance.Employee");

		// Create a new instance with empty argument of constructor of a class
		Employee employee = (Employee) clazz.newInstance();
		employee.setId(1);
		employee.setName("gpcoder");
		System.out.println("employee: " + employee);
	}
}
