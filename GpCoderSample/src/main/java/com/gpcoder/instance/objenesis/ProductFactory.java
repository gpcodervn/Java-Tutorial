package com.gpcoder.instance.objenesis;

public class ProductFactory {

	private ProductFactory() {
		throw new UnsupportedOperationException("Cannot call the contructor directly");
	}

	public void doSomething(String factory) {
		System.out.println("Working on " + factory);
	}
}
