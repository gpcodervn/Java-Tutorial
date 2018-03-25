package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RemoveStartTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.removeStart(null, "0."));
		System.out.println(StringUtils.removeStart("0.1234", "0."));
		System.out.println(StringUtils.removeStart("0.1234", "0.12"));
		System.out.println(StringUtils.removeStart("0.1234", "0.34"));
	}

}
