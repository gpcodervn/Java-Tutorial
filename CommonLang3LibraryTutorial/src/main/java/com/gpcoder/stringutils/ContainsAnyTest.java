package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsAnyTest {

	public static void main(String[] args) {
		String string = "gpcoder.com";
		System.out.println(StringUtils.containsAny(string, 'a', 'b', 'c')); // true
		System.out.println(StringUtils.containsAny(string, 'x', 'y', 'z')); // false
		System.out.println(StringUtils.containsAny(string, "abc")); // true
		System.out.println(StringUtils.containsAny(string, "xyz")); // false
	}

}
