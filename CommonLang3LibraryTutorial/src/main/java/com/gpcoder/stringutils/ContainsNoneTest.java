package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsNoneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.containsNone(null, 'a'));
		System.out.println(StringUtils.containsNone("abc", 'd'));
		System.out.println(StringUtils.containsNone("acbccbba", 'a', 'b', 'c', 'd'));
		System.out.println(StringUtils.containsNone("acbccbba", "xyz".toCharArray()));
		
		System.out.println(StringUtils.containsNone(null, "a"));
		System.out.println(StringUtils.containsNone("abc", "d"));
		System.out.println(StringUtils.containsNone("acbccbba", "abcd"));
		System.out.println(StringUtils.containsNone("acbccbba", "xyz"));
	}

}
