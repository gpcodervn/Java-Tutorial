package com.gpcoder.context;

import org.apache.commons.chain.impl.ContextBase;

import lombok.Data;

@Data
public class MyContext extends ContextBase {

	private String property;
}