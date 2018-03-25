package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAllUpperCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAllUpperCase(null));
		System.out.println(StringUtils.isAllUpperCase(""));
		System.out.println(StringUtils.isAllUpperCase("   "));
		System.out.println(StringUtils.isAllUpperCase("Java"));
		System.out.println(StringUtils.isAllUpperCase("JAVA"));
		System.out.println(StringUtils.isAllUpperCase("gp coder"));
	}

}
