package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class DefaultIfBlankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //StringUtils.defaultIfBlank(String str, String defaultStr)
		System.out.println(StringUtils.defaultIfBlank(null, "N/A")); 
		System.out.println(StringUtils.defaultIfBlank("", "N/A"));
		System.out.println(StringUtils.defaultIfBlank("   ", "N/A"));
		System.out.println(StringUtils.defaultIfBlank("java", "N/A"));
	}

}
