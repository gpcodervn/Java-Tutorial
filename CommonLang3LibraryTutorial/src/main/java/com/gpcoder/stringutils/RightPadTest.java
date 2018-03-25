package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RightPadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.rightPad("9", 5, "0"));
		System.out.println(StringUtils.rightPad("99", 5, "0"));
		System.out.println(StringUtils.rightPad("999", 5, "0"));
		System.out.println(StringUtils.rightPad("9999", 5, "0"));
		System.out.println(StringUtils.rightPad("99999", 5, "0"));
	}

}
