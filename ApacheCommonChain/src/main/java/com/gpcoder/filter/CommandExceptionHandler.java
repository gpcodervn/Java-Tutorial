package com.gpcoder.filter;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

public class CommandExceptionHandler implements Filter {

	public boolean execute(Context context) throws Exception {
		System.out.println("CommandExceptionHandler.execute() called.");
		return false;
	}

	public boolean postprocess(Context context, Exception exception) {
		if (exception == null) {
			return false;
		}
		System.out.println("Exception " + exception.getMessage() + " occurred.");
		return true;
	}
}