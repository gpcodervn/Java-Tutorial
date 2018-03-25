package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class LastIndexIgnoreCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.lastIndexOfIgnoreCase(null, null));
		System.out.println(StringUtils.lastIndexOfIgnoreCase("ABCABAABAAB", "ab"));
		System.out.println(StringUtils.lastIndexOfIgnoreCase("ABCABAABAAB", "AB"));
		System.out.println(StringUtils.lastIndexOfIgnoreCase("Welcome to gpcoder blog", "GPCODER"));
	}

}
