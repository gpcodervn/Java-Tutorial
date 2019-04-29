package com.gpcoder.example1_chain;

import org.apache.commons.chain.impl.ChainBase;

import com.gpcoder.command.Command1;
import com.gpcoder.command.Command2;

public class MyChain extends ChainBase {

	public MyChain() {
		super();
		addCommand(new Command1());
		addCommand(new Command2());
	}
}