package com.gpcoder.exception;

public class CustomAutoClosable implements AutoCloseable {

	public void yourAction() {
		System.out.println("yourAction working ...");
	}

	@Override
	public void close() throws Exception {
		System.out.println("CustomAutoClosable closed!");
	}
}
