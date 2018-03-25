package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RemoveStartIgnoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.removeStartIgnoreCase(null, "be"));
		System.out.println(StringUtils.removeStartIgnoreCase("gp coder", "gp "));
		System.out.println(StringUtils.removeStartIgnoreCase("gp coder", "GP "));
		System.out.println(StringUtils.removeStartIgnoreCase("gp coder", "gP"));
	}

}
