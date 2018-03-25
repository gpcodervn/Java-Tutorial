package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAlphaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAlpha(null));
		System.out.println(StringUtils.isAlpha(""));
		System.out.println(StringUtils.isAlpha("GPC"));
		System.out.println(StringUtils.isAlpha("be the coder"));
		System.out.println(StringUtils.isAlpha("1234"));
		System.out.println(StringUtils.isAlpha("GPC1234"));
	}

}
