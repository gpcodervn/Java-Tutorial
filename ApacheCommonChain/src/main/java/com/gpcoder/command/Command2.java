package com.gpcoder.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.gpcoder.context.MyContext;

public class Command2 implements Command {
	
	public boolean execute(Context ctx) throws Exception {
		String value = ((MyContext) ctx).getProperty();
		System.out.println("This is command 2: " + value);
		return false;
	}
}