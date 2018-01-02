package com.gpcoder.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ChangeStaticFinalFieldExample {
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// create Cat
		Cat cat = new Cat();
		
		// Get field instance
		Field field = cat.getClass().getDeclaredField("NUMBER_OF_LEGS");
		field.setAccessible(true); // Suppress Java language access checking

		// Remove "final" modifier
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		// Get value
		Integer fieldValue = (Integer) field.get(null);
		System.out.println(cat.getNumberOfLegs()); // -> 4

		// Set value
		field.set(null, 2);
		System.out.println(cat.getNumberOfLegs()); // -> 2
	}
}
