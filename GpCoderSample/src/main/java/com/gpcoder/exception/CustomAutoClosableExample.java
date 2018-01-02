package com.gpcoder.exception;

public class CustomAutoClosableExample {

	public static void main(String[] args) throws Exception {

		try (CustomAutoClosable closAble = new CustomAutoClosable()) {
			closAble.yourAction();
		}

	}
}
