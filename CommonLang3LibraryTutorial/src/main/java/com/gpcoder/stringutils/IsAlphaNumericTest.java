package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAlphaNumericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAlphanumeric(null));
		System.out.println(StringUtils.isAlphanumeric(""));
		System.out.println(StringUtils.isAlphanumeric("  "));
		System.out.println(StringUtils.isAlphanumeric("GPC"));
		System.out.println(StringUtils.isAlphanumeric("gp coder"));
		System.out.println(StringUtils.isAlphanumeric("1234"));
		System.out.println(StringUtils.isAlphanumeric("GPC1234"));
	}

}
