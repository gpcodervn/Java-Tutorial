package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class LeftPadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.leftPad("9", 5, "0"));
		System.out.println(StringUtils.leftPad("99", 5, "0"));
		System.out.println(StringUtils.leftPad("999", 5, "0"));
		System.out.println(StringUtils.leftPad("9999", 5, "0"));
		System.out.println(StringUtils.leftPad("99999", 5, "0"));
	}

}
