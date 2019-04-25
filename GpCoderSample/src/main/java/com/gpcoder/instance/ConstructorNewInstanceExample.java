package com.gpcoder.instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorNewInstanceExample {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		// Get class based on the given class name
		Class<?> clazz = Class.forName("com.gpcoder.instance.Employee");

		// Get all constructor of the class
		Constructor<?>[] allConstructors = clazz.getConstructors();
		for (Constructor<?> constructor : allConstructors) {
			Class<?>[] parameters = constructor.getParameterTypes();
			if (parameters.length == 0) {
				// Create a new instance without parameter
				Employee employee1 = (Employee) constructor.newInstance();
				employee1.setId(1);
				employee1.setName("gpcoder 1");
				System.out.println("employee1: " + employee1);
			} else if (parameters.length == 2) {
				// Create a new instance with two parameters
				Employee employee2 = (Employee) constructor.newInstance(2, "gpcoder 2");
				System.out.println("employee2: " + employee2);
			}
		}
		
		// Create a new instance with specific constructor of class
		Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
		Employee employee3 = (Employee) constructor.newInstance(3, "gpcoder 3");
		System.out.println("employee3: " + employee3);
	}
}
