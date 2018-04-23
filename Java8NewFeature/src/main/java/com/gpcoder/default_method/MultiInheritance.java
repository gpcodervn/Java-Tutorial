package com.gpcoder.default_method;

interface Interface1 {
	default void doSomething() {

	}
}

interface Interface2 {
	default void doSomething() {

	}
}

public class MultiInheritance implements Interface1, Interface2 {

	@Override
	public void doSomething() {
		Interface1.super.doSomething();
	}

}
