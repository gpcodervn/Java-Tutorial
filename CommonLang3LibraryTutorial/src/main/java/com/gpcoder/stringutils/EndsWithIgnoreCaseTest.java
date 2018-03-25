package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class EndsWithIgnoreCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.endsWithIgnoreCase(null, "coder"));
		System.out.println(StringUtils.endsWithIgnoreCase("", "coder"));
		System.out.println(StringUtils.endsWithIgnoreCase("gp coder", "coder"));
		System.out.println(StringUtils.endsWithIgnoreCase("java", "va"));
		System.out.println(StringUtils.endsWithIgnoreCase("GP CODER", "coder"));
		System.out.println(StringUtils.endsWithIgnoreCase("Java", "VA"));
	}

}
