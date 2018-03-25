package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsNotEmptyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isNotEmpty(null));
		System.out.println(StringUtils.isNotEmpty(""));
		System.out.println(StringUtils.isNotEmpty(" "));
		System.out.println(StringUtils.isNotEmpty("GPC"));
	}

}
