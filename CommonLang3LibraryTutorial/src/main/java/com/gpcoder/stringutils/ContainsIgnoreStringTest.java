package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsIgnoreStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.containsIgnoreCase(null, "a"));
		System.out.println(StringUtils.containsIgnoreCase("", ""));
		System.out.println(StringUtils.containsIgnoreCase("gp coder", ""));
		System.out.println(StringUtils.containsIgnoreCase("gp coder", "co"));
		System.out.println(StringUtils.containsIgnoreCase("gp coder", "CO"));
		System.out.println(StringUtils.containsIgnoreCase("gp coder", "abc"));
	}

}
