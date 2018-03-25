package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsOnlyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.containsOnly(null, 'a'));
		System.out.println(StringUtils.containsOnly("abc", 'b'));
		System.out.println(StringUtils.containsOnly("acbccbba", 'a', 'b', 'c'));
		System.out.println(StringUtils.containsOnly("acbccbba", "abc".toCharArray()));

		System.out.println(StringUtils.containsOnly(null, "a"));
		System.out.println(StringUtils.containsOnly("abc", "b"));
		System.out.println(StringUtils.containsOnly("acbccbba", "abc"));
		System.out.println(StringUtils.containsOnly("xyyx", "xyz"));
	}

}
