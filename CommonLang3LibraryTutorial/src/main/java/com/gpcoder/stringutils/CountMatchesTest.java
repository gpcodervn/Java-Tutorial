package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class CountMatchesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.countMatches(null, "ab"));
		System.out.println(StringUtils.countMatches("", "ab"));
		System.out.println(StringUtils.countMatches("abcaabbabbcaabb", "ab"));
		System.out.println(StringUtils.countMatches("abcaabbabbcaabb", ""));
		System.out.println(StringUtils.countMatches("abcaabbabbcaabb", "xy"));
		System.out.println(StringUtils.countMatches("zxyxzyzxyz", "xy"));
	}

}
