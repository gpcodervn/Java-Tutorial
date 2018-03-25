package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsWhiteSpaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isWhitespace(null));
		System.out.println(StringUtils.isWhitespace(""));
		System.out.println(StringUtils.isWhitespace("   "));
		System.out.println(StringUtils.isWhitespace("gp coder"));
	}

}
