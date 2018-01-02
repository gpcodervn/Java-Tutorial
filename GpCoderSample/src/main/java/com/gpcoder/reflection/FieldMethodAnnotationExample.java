package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FieldMethodAnnotationExample {

	@MyAnnotation(name = "My Field")
	private int myField;

	@MyAnnotation(name = "My Method", value = "My Method Value")
	protected void myMethod(String str) {

	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		// Lấy đối tượng Class
		Class<?> aClazz = FieldMethodAnnotationExample.class;

		// Lấy đối tượng Field
		System.out.println(" == FIELD == ");
		Field field = aClazz.getDeclaredField("myField");

		// Lấy ra danh sách các Annotation của field.
		Annotation[] fieldAnns = field.getAnnotations();
		for (Annotation methodAnn : fieldAnns) {
			System.out.println("Annotation: " + methodAnn.annotationType().getSimpleName());
		}

		// Lấy cụ thể.
		Annotation fieldAnn = field.getAnnotation(MyAnnotation.class);
		MyAnnotation myAnn1 = (MyAnnotation) fieldAnn;
		System.out.println("Name = " + myAnn1.name());
		System.out.println("Value = " + myAnn1.value());

		// Tương tự với method ...
		System.out.println(" == METHOD == ");
		Method method = aClazz.getDeclaredMethod("myMethod", String.class);
		// Lấy ra danh sách các Annotation của method.
		Annotation[] methodAnns = method.getAnnotations();
		for (Annotation methodAnn : methodAnns) {
			System.out.println("Annotation: " + methodAnn.annotationType().getSimpleName());
		}

		// Lấy cụ thể.
		Annotation methodAnn = method.getAnnotation(MyAnnotation.class);
		MyAnnotation myAnn2 = (MyAnnotation) methodAnn;
		System.out.println("Name = " + myAnn2.name());
		System.out.println("Value = " + myAnn2.value());

	}
}