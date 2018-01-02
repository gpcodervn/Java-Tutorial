package com.gpcoder.reflection;

import java.lang.reflect.Field;

public class AccessPrivateFieldExample {
	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		// Tạo một đối tượng Class mô tả class Cat.
		Class<Cat> aClazz = Cat.class;

		// Class.getField(String) chỉ lấy được các trường public.
		// Sử dụng Class.getDeclaredField(String):
		// Lấy ra đối tượng Field mô tả trường name của class Cat.
		// (Trường khi báo trong class này).
		Field private_nameField = aClazz.getDeclaredField("name");

		// Cho phép để truy cập vào các trường private.
		// Nếu không sẽ bị ngoại lệ IllegalAccessException
		private_nameField.setAccessible(true);

		Cat tom = new Cat("Tom");

		String fieldValue = (String) private_nameField.get(tom);
		System.out.println("Value field name = " + fieldValue);

		// Sét đặt trường name giá trị mới.
		private_nameField.set(tom, "Tom Cat");

		System.out.println("New name = " + tom.getName());
	}
}
