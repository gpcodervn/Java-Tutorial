package com.gpcoder.annotation;

public class AnnotationOverrideExample {

	class Parent {
		public void parentMethod() {
			System.out.println("This is parrent");
		}
	}

	class Child1 extends Parent {
		@Override
		public void parentMethod() {
			System.out.println("This is child 1");
		}
	}

	class Child2 extends Parent {
		public void parentMethod() {
			System.out.println("This is child 2");
		}
	}

}
