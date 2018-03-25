package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class LastIndexOfAnyStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.lastIndexOfAny(null, "a"));
		System.out.println(StringUtils.lastIndexOfAny("ababcpabbabc", "p", "ab"));
		System.out.println(StringUtils.lastIndexOfAny("ababcpabbabc", "x", "yz", "ayz"));
		System.out.println(StringUtils.lastIndexOfAny("ababcpabbabc", "abc", "bc", "c"));
	}

}
