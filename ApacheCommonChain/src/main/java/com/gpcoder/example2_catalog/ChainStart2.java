package com.gpcoder.example2_catalog;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;

import com.gpcoder.constant.MyCommandNamed;
import com.gpcoder.context.MyContext;

/**
 * Execute the specific command example
 */
public class ChainStart2 {

	public static void main(String[] args) throws Exception {

		// Create context
		MyContext ctx = new MyContext();
		ctx.setProperty("property-value");
		ctx.put("custom-key", "custom-value");

		// Get the catalog
		Catalog catalog = new MyCatalog();

		// Get the command
		System.out.println("Execute the specific command: CMD_1");
		Command command1 = catalog.getCommand(MyCommandNamed.CMD_1.name());
		command1.execute(ctx);

		System.out.println("\nExecute the specific chain: CHAIN_1");
		Command chain1 = catalog.getCommand(MyCommandNamed.CHAIN_1.name());
		chain1.execute(ctx);
	}
}