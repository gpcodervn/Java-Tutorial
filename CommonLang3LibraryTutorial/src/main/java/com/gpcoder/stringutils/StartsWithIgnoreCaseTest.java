package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StartsWithIgnoreCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.startsWithIgnoreCase(null, "gp"));
		System.out.println(StringUtils.startsWithIgnoreCase("", "gp"));
		System.out.println(StringUtils.startsWithIgnoreCase("gp coder", "gp"));
		System.out.println(StringUtils.startsWithIgnoreCase("Java", "ja"));
		System.out.println(StringUtils.startsWithIgnoreCase("GP CODER", "gp"));
		System.out.println(StringUtils.startsWithIgnoreCase("java", "gp"));
	}

}
