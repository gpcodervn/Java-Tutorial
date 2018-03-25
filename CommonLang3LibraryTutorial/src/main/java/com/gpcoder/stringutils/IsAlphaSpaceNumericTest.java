package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsAlphaSpaceNumericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.isAlphanumericSpace(null));
		System.out.println(StringUtils.isAlphanumericSpace(""));
		System.out.println(StringUtils.isAlphanumericSpace("  "));
		System.out.println(StringUtils.isAlphanumericSpace("GPC"));
		System.out.println(StringUtils.isAlphanumericSpace("gp coder"));
		System.out.println(StringUtils.isAlphanumericSpace("1234"));
		System.out.println(StringUtils.isAlphanumericSpace("GPC1234"));
		System.out.println(StringUtils.isAlphanumericSpace("GPC@1234"));
	}

}
