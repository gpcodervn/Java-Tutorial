package com.gpcoder.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

import com.gpcoder.context.MyContext;

public class Command1 implements Command {
	
	public boolean execute(Context ctx) throws Exception {
		System.out.println("This is command 1: ");

		String property = ((MyContext) ctx).getProperty();
		System.out.println("+ property: " + property);

		String customValue = ctx.get("custom-key").toString();
		System.out.println("+ customValue: " + customValue);

		return false;
	}
}