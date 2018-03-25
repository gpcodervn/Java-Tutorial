package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class AbbreviateTest {

	public static void main(String[] args) {

		System.out.println(StringUtils.abbreviate(null, 6));
		System.out.println(StringUtils.abbreviate("", 6));
		System.out.println(StringUtils.abbreviate("abcdefgh", 6)); // (string, maxWidth)
		System.out.println(StringUtils.abbreviate("abcdefgh", 5));
		System.out.println(StringUtils.abbreviate("abcdefgh", 4));

	}

}
