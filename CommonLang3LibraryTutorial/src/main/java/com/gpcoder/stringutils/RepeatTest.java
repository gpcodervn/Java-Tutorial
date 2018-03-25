package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RepeatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringUtils.repeat("*", 6));
		System.out.println(StringUtils.repeat("GPC ", 4));
		System.out.println(StringUtils.repeat("+-", 6));
	}

}
