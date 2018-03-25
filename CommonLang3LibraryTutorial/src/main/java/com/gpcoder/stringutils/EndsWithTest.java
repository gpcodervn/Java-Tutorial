package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class EndsWithTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.endsWith(null, "coder"));
		System.out.println(StringUtils.endsWith("", "coder"));
		System.out.println(StringUtils.endsWith("gp coder", "coder"));
		System.out.println(StringUtils.endsWith("java", "va"));
		System.out.println(StringUtils.endsWith("GP CODER", "coder"));
		System.out.println(StringUtils.endsWith("java", "xyz"));
	}

}
