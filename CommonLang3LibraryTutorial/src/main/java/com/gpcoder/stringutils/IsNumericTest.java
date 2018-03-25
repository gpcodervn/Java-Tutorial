package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsNumericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isNumeric(null));
		System.out.println(StringUtils.isNumeric(""));
		System.out.println(StringUtils.isNumeric("gp coder"));
		System.out.println(StringUtils.isNumeric("1234"));
		System.out.println(StringUtils.isNumeric("1234.45"));
	}

}
