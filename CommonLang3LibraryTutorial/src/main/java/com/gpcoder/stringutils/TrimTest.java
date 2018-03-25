package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class TrimTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.trim(null));
		System.out.println(StringUtils.trim(""));
		System.out.println(StringUtils.trim(" "));
		System.out.println(StringUtils.trim(" GPC     "));
	}

}
