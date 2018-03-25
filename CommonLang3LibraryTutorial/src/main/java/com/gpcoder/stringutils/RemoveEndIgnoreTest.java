package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RemoveEndIgnoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.removeEndIgnoreCase(null, "coder"));
		System.out.println(StringUtils.removeEndIgnoreCase("gp coder", "coder"));
		System.out.println(StringUtils.removeEndIgnoreCase("gp coder", "CODER"));
		System.out.println(StringUtils.removeEndIgnoreCase("gp coder", "the"));
	}

}
