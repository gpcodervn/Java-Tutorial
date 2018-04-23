package com.gpcoder.static_method;

interface Vehicle {

	default void print() {
		if (isValid())
			System.out.println("Vehicle printed");
	}

	static boolean isValid() {
		System.out.println("Vehicle is valid");
		return true;
	}

	void showLog();

}

public class Car implements Vehicle {

	@Override
	public void showLog() {
		print();
		Vehicle.isValid();
	}
	
	static boolean isValid() {
		return true;
	}

}
