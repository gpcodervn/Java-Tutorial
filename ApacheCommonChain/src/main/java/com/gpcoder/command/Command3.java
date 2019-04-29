package com.gpcoder.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public class Command3 implements Command {

	public boolean execute(Context ctx) throws Exception {
		throw new UnsupportedOperationException("Cannot execute Command4");
	}
}