package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StartsWithTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.startsWith(null, "gp"));
		System.out.println(StringUtils.startsWith("", "gp"));
		System.out.println(StringUtils.startsWith("gp coder", "gp"));
		System.out.println(StringUtils.startsWith("java", "ja"));
		System.out.println(StringUtils.startsWith("GP CODER", "gp"));
		System.out.println(StringUtils.startsWith("java", "gp"));
	}

}
