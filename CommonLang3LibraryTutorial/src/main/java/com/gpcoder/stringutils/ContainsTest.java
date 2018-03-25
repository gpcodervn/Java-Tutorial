package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ContainsTest {

	public static void main(String[] args) {
		System.out.println(StringUtils.contains(null, 'a'));
		System.out.println(StringUtils.contains("gp coder", 'c'));
		System.out.println(StringUtils.contains("gp coder", 'C'));
		System.out.println(StringUtils.contains("gp coder", 'x'));

		System.out.println(StringUtils.contains(null, "a"));
		System.out.println(StringUtils.contains("", ""));
		System.out.println(StringUtils.contains("be the coder", ""));
		System.out.println(StringUtils.contains("be the coder", "the"));
		System.out.println(StringUtils.contains("be the coder", "co"));
		System.out.println(StringUtils.contains("be the coder", "abc"));
	}

}
