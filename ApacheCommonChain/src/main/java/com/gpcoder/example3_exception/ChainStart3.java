package com.gpcoder.example3_exception;

import org.apache.commons.chain.Command;

import com.gpcoder.context.MyContext;

/**
 * Filter for exception handling in Chains example
 */
public class ChainStart3 {

	public static void main(String[] args) throws Exception {
		Command chain = new MyChain3();
		chain.execute(new MyContext());
	}
}