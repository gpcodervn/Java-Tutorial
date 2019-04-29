package com.gpcoder.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.gpcoder.context.MyContext;

public class Command4 implements Command {
	
	public boolean execute(Context ctx) throws Exception {
		String value = ((MyContext) ctx).getProperty();
		System.out.println("This is command 4: " + value);
		return false;
	}
}