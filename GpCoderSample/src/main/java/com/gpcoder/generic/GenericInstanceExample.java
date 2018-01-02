package com.gpcoder.generic;

public class GenericInstanceExample {
	public static void main(String[] args) 
			throws InstantiationException, IllegalAccessException {

		GenericInstance<Student> generic = new GenericInstance<Student>(Student.class);
		Student student = generic.getObj();
		System.out.println(student);
		
	}
}
