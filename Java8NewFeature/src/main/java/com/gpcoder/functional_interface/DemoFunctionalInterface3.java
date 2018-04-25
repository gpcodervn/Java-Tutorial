package com.gpcoder.functional_interface;

@FunctionalInterface
public interface DemoFunctionalInterface3 {

	void doSomething();

	default void defaultMethod1() {

	}

	default void defaultMethod2() {

	}

	static void staticMethod() {

	}

}