package com.gpcoder.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParameterAnnotationExample {

	// Ví dụ một method có Annotation ở tham số.
	protected void doSomething(int jobType, @MyAnnotation(name = "Table", value = "Employee") String info) {

	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		// Lấy đối tượng Class
		Class<?> aClass = ParameterAnnotationExample.class;

		// Lấy ra đối tượng Method của method doSomething(int,String)
		Method method = aClass.getDeclaredMethod("doSomething", int.class, String.class);

		// Lấy ra danh sách các Parameter của method.
		Class<?>[] parameterTypes = method.getParameterTypes();
		for (Class<?> parameterType : parameterTypes) {
			System.out.println("Parametete Type: " + parameterType.getSimpleName());
		}

		System.out.println(" ---- ");

		// Lấy ra mảng 2 chiều các Annotation trong các Parameter.
		Annotation[][] annotationss = method.getParameterAnnotations();

		// Lấy ra danh sách các Annotation của Parameter tại vị trí Index =1.
		Annotation[] annotations = annotationss[1];
		for (Annotation ann : annotations) {
			System.out.println("Annotation: " + ann.annotationType().getSimpleName());
		}
	}
}