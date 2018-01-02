package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectFieldExample {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		// Lấy ra đối tượng Class mô tả class Cat
		Class<Cat> aClazz = Cat.class;

		// Lấy ra danh sách các field public
		// Kể các các public field thừa kế từ các class cha, và các interface
		System.out.println("Field:");
		Field[] fields = aClazz.getFields();
		for (Field field : fields) {
			System.out.println("+ " + field.getName());
		}

		// Lấy ra field có tên 'NUMBER_OF_LEGS':
		Field field = aClazz.getField("NUMBER_OF_LEGS");

		// Ghi ra kiểu của Field
		Class<?> fieldType = field.getType();
		System.out.println("Field type: " + fieldType.getSimpleName());

		// Khởi tạo đối tượng Cat
		Cat tom = new Cat("Tom", 1);

		// Lấy ra giá trị của trường "age" theo cách của Reflect.
		Field ageField = aClazz.getField("age");
		Integer age = (Integer) ageField.get(tom);
		System.out.println("Age = " + age);

		// Gán giá trị mới cho trường "age".
		ageField.set(tom, 2);
		System.out.println("New Age = " + tom.getAge());

		// Lấy ra danh sách các Annotation của field.
		System.out.println("\nAnnotation:");
		Annotation[] annotations = ageField.getAnnotations();
		for (Annotation ann : annotations) {
			System.out.println("+ " + ann.annotationType().getSimpleName());
		}
	}

}
