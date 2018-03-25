package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAllLowerCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAllLowerCase(null));
		System.out.println(StringUtils.isAllLowerCase(""));
		System.out.println(StringUtils.isAllLowerCase("   "));
		System.out.println(StringUtils.isAllLowerCase("java"));
		System.out.println(StringUtils.isAllLowerCase("Java"));
		System.out.println(StringUtils.isAllLowerCase("gp coder"));
	}

}
