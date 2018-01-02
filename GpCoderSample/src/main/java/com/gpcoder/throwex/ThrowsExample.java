package com.gpcoder.throwex;

import java.io.IOException;

public class ThrowsExample {

	void method() throws IOException {
		System.out.println("device operation performed");  
	}

	public static void main(String args[]) throws IOException {
		ThrowsExample obj = new ThrowsExample();
		obj.method();
		System.out.println("normal flow...");
	}

}
