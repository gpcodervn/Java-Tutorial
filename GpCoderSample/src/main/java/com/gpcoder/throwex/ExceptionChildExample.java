package com.gpcoder.throwex;

public class ExceptionChildExample extends Parent {
	void msg() {
		System.out.println("child");
	}

	public static void main(String args[]) {
		Parent p = new ExceptionChildExample();
		try {
			p.msg();
		} catch (Exception e) {
		}
	}
}