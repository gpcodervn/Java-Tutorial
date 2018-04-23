package com.gpcoder.default_method;

interface Interface3 {
	default void doSomething() {
		System.out.println("Execute in Interface3");
	}
}

class Parent {
	public void doSomething() {
		System.out.println("Execute in Parent");
	}
}

public class MultiInheritance2 extends Parent implements Interface3 {

	public static void main(String[] args) {
		MultiInheritance2 m = new MultiInheritance2();
		m.doSomething(); // Execute in Parent
	}

}