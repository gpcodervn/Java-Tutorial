package com.gpcoder.example2_catalog;

import org.apache.commons.chain.impl.CatalogBase;

import com.gpcoder.command.Command1;
import com.gpcoder.command.Command2;
import com.gpcoder.constant.MyCommandNamed;
import com.gpcoder.example1_chain.MyChain;

/**
 * CatalogBase is a collection of Chains and Commands with their logical names.
 */
public class MyCatalog extends CatalogBase {

	public MyCatalog() {
		super();
		addCommand(MyCommandNamed.CMD_1.name(), new Command1());
		addCommand(MyCommandNamed.CMD_2.name(), new Command2());
		addCommand(MyCommandNamed.CHAIN_1.name(), new MyChain());
	}
}