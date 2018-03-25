package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class EqualsIgnoreCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.equalsIgnoreCase(null, null));
		System.out.println(StringUtils.equalsIgnoreCase(null, ""));
		System.out.println(StringUtils.equalsIgnoreCase("", ""));
		System.out.println(StringUtils.equalsIgnoreCase("", "        "));
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "gpcoder"));
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "GPCoder"));
	}

}
