package com.gpcoder.supplier;

import java.util.function.Supplier;

class Student {
	public Student() {
		System.out.println("Create new student");
	}
}

public class UsingSupplierExample2 {

	public static void main(String[] args) {
		Student s = supplyElements(Student::new);
	}

	public static <T> T supplyElements(Supplier<T> supplier) {
		System.out.println("Calling create new object");
		return supplier.get();
	}
}
