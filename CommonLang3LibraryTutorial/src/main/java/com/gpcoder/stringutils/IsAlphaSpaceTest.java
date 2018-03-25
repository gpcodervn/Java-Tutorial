package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAlphaSpaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAlphaSpace(null));
		System.out.println(StringUtils.isAlphaSpace(""));
		System.out.println(StringUtils.isAlphaSpace("  "));
		System.out.println(StringUtils.isAlphaSpace("GPC"));
		System.out.println(StringUtils.isAlphaSpace("gp coder"));
		System.out.println(StringUtils.isAlphaSpace("1234"));
		System.out.println(StringUtils.isAlphaSpace("GPC1234"));
	}

}
