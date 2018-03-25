package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class DefaultIfEmptyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    //StringUtils.defaultIfEmpty(String str, String defaultStr)
		System.out.println(StringUtils.defaultIfEmpty(null, "N/A"));
		System.out.println(StringUtils.defaultIfEmpty("", "N/A"));
		System.out.println(StringUtils.defaultIfEmpty("   ", "N/A"));
		System.out.println(StringUtils.defaultIfEmpty("java", "N/A"));
	}

}
