package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IndexOfAnyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.indexOfAny(null, 'a'));
		System.out.println(StringUtils.indexOfAny("gp coder", 'g'));
		System.out.println(StringUtils.indexOfAny("gp coder", 'c', 'o', 'd', 'e', 'r'));
		System.out.println(StringUtils.indexOfAny("gp coder", "abc".toCharArray()));
		System.out.println(StringUtils.indexOfAny("abcd", 'x', 'y', 'z'));

		System.out.println(StringUtils.indexOfAny(null, "a"));
		System.out.println(StringUtils.indexOfAny("gp coder", "j", "coder"));
		System.out.println(StringUtils.indexOfAny("gp coder", "gp", "welcome", "coder"));
		System.out.println(StringUtils.indexOfAny("gp coder", "ab", "xyz"));
	}

}
