package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class EqualsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.equals(null, null));
		System.out.println(StringUtils.equals(null, ""));
		System.out.println(StringUtils.equals("", ""));
		System.out.println(StringUtils.equals("", "        "));
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "gpcoder"));
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "GPCoder"));
	}

}
