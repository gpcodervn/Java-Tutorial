package com.gpcoder.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3271661431899334345L;

	public RecordNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}