package com.gpcoder.reflection;

import java.lang.reflect.Method;

public class ReflectMethodExample2 {

	public static void main(String[] args) {

		// Lấy ra đối tượng Class mô tả class Cat
		Class<Cat> aClazz = Cat.class;

		// Lấy ra danh sách các public method.
		Method[] methods = aClazz.getMethods();

		for (Method method : methods) {
			System.out.println("Method: " + method.getName());
			System.out.println(" - Is Setter? " + isSetter(method));
			System.out.println(" - Is Getter? " + isGetter(method));
		}

	}

	// Method là getter nếu có tên bắt đầu bằng get, và không có tham số.
	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get")) {
			return false;
		}
		if (method.getParameterTypes().length != 0) {
			return false;
		}
		if (void.class.equals(method.getReturnType())) {
			return false;
		}
		return true;
	}

	// Method là setter nếu có tên bắt đầu bằng set, và chỉ có 1 tham số.
	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set")) {
			return false;
		}
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		return true;
	}

}
