package com.gpcoder.example1_chain;

import org.apache.commons.chain.Command;

import com.gpcoder.context.MyContext;

/**
 * Execute a chain example
 */
public class ChainStart1 {

	public static void main(String[] args) throws Exception {
		// Create context
		MyContext context = new MyContext();
		context.setProperty("property-value");
		context.put("custom-key", "custom-value");

		// Get the command
		Command command = new MyChain();
		command.execute(context);
	}
}
