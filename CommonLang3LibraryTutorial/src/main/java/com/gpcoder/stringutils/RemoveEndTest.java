package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RemoveEndTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.removeEnd(null, ".12"));
		System.out.println(StringUtils.removeEnd("999.12", ".12"));
		System.out.println(StringUtils.removeEnd("999.1234", ".12"));
		System.out.println(StringUtils.removeEnd("8888.1234", ".1234"));
	}

}
