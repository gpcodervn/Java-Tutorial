package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsNotBlankTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isNotBlank(null));
		System.out.println(StringUtils.isNotBlank(""));
		System.out.println(StringUtils.isNotBlank(" "));
		System.out.println(StringUtils.isNotBlank("GPC"));
	}

}
