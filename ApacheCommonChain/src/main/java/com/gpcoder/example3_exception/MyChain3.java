package com.gpcoder.example3_exception;

import org.apache.commons.chain.impl.ChainBase;

import com.gpcoder.command.Command1;
import com.gpcoder.command.Command3;
import com.gpcoder.filter.CommandExceptionHandler;

public class MyChain3 extends ChainBase {

	public MyChain3() {
		super();
		addCommand(new CommandExceptionHandler());
		addCommand(new Command1());
		addCommand(new Command3());
	}
}