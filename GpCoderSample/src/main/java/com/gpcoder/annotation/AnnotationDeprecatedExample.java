package com.gpcoder.annotation;

public class AnnotationDeprecatedExample {

	class Parent {
		/**
		 * @deprecated Do not use this method! Replaced by parentMethod2
		 */
		@Deprecated
		public void parentMethod1() {

		}

		public void parentMethod2() {

		}
	}

	class Child {
		public void childMethod() {
			Parent p = new Parent();
			p.parentMethod1();
		}
	}

}
