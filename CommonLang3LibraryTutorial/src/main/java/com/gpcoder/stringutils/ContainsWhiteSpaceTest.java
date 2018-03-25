package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsWhiteSpaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.containsWhitespace(null));
		System.out.println(StringUtils.containsWhitespace(""));
		System.out.println(StringUtils.containsWhitespace(" "));
		System.out.println(StringUtils.containsWhitespace("commons lang"));
		System.out.println(StringUtils.containsWhitespace("java"));
	}

}
