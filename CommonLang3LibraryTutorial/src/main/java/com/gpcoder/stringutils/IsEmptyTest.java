package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IsEmptyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isEmpty(null));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(" "));
		System.out.println(StringUtils.isEmpty("GPC"));
	}

}
