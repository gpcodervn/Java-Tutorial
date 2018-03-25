package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class DeleteWhiteSpaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.deleteWhitespace(null));
		System.out.println(StringUtils.deleteWhitespace(""));
		System.out.println(StringUtils.deleteWhitespace("gp coder"));
		System.out.println(StringUtils.deleteWhitespace("    java   "));
	}

}
