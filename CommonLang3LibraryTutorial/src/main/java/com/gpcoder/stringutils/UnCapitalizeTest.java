package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class UnCapitalizeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.uncapitalize(null));
		System.out.println(StringUtils.uncapitalize(""));
		System.out.println(StringUtils.uncapitalize("Name"));
		System.out.println(StringUtils.uncapitalize("Age"));
		System.out.println(StringUtils.uncapitalize("AGE"));
		System.out.println(StringUtils.uncapitalize("AGe"));
	}

}
