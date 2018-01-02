package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectClassExample {

	public static void main(String[] args) {
		try {
			getClassInfo();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void getClassInfo() throws ClassNotFoundException {
		Class<?> aClazz = Class.forName("com.gpcoder.reflection.Cat");
		System.out.println("Name: " + aClazz.getName());
		System.out.println("Simple Name: " + aClazz.getSimpleName());

		Package pkg = aClazz.getPackage();
		System.out.println("Package Name = " + pkg.getName());

		// Modifier
		int modifiers = aClazz.getModifiers();
		boolean isPublic = Modifier.isPublic(modifiers);
		boolean isInterface = Modifier.isInterface(modifiers);
		boolean isAbstract = Modifier.isAbstract(modifiers);
		boolean isFinal = Modifier.isFinal(modifiers);

		System.out.println("Is Public? " + isPublic); // true
		System.out.println("Is Final? " + isFinal); // false
		System.out.println("Is Interface? " + isInterface); // false
		System.out.println("Is Abstract? " + isAbstract); // false

		// Lấy ra đối tượng class mô tả class cha của class Cat.
		Class<?> aSuperClass = aClazz.getSuperclass();
		System.out.println("Simple Class Name of Super class = " + aSuperClass.getSimpleName());

		// Lấy ra mảng các Class mô tả các Interface mà Cat thi hành
		System.out.println("\nInterface:");
		Class<?>[] itfClasses = aClazz.getInterfaces();
		for (Class<?> itfClass : itfClasses) {
			System.out.println("+ " + itfClass.getSimpleName());
		}

		// Lấy ra danh sách các cấu tử của Cat.
		System.out.println("\nConstructor:");
		Constructor<?>[] constructors = aClazz.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("+ " + constructor.getName() + " has " + constructor.getParameterCount() + " param");
		}

		// Lấy ra danh sách các method public của Cat
		// Bao gồm cả các method thừa kế từ class cha và các interface
		System.out.println("\nDeclared Methods:");
		Method[] methods = aClazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("+ " + method.getName());
		}

		// Lấy ra danh sách các field public
		// Kể các các public field thừa kế từ các class cha, và các interface
		System.out.println("\nField:");
		Field[] fields = aClazz.getFields();
		for (Field field : fields) {
			System.out.println("+ " + field.getName());
		}

		// Lấy ra danh sách các Annotation của class.
		System.out.println("\nAnnotation:");
		Annotation[] annotations = aClazz.getAnnotations();
		for (Annotation ann : annotations) {
			System.out.println("+ " + ann.annotationType().getSimpleName());
		}
	}
}
