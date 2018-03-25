package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsBlankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank(" "));
		System.out.println(StringUtils.isBlank("GPC"));
	}

}
