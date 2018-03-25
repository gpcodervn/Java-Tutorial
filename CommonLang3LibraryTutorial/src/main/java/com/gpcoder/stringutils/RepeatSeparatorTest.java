package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RepeatSeparatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringUtils.repeat("ABC", ":", 6));
		System.out.println(StringUtils.repeat("GPC", " ", 4));
		System.out.println(StringUtils.repeat("123", " > ", 6));
	}

}
