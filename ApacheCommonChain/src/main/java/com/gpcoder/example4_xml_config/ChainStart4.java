package com.gpcoder.example4_xml_config;

import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;

import com.gpcoder.constant.MyCommandNamed;
import com.gpcoder.context.MyContext;

/**
 * Get the catalog from XML file and Execute the specific command example
 */
public class ChainStart4 {

	public static void main(String[] args) throws Exception {
		// Create context
		MyContext ctx = new MyContext();
		ctx.setProperty("property-value");
		ctx.put("custom-key", "custom-value");

		// Get the catalog
		Catalog catalog = new MyXMLCatalog().getCatalog();

		// Get the command
		System.out.println("Execute the specific command: CMD_1");
		Command command1 = catalog.getCommand(MyCommandNamed.CMD_1.name());
		command1.execute(ctx);

		System.out.println("\nExecute the specific chain: CHAIN_1");
		Command chain1 = catalog.getCommand(MyCommandNamed.CHAIN_1.name());
		chain1.execute(ctx);
	}
}