package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class SwapCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.swapCase(null));
		System.out.println(StringUtils.swapCase(""));
		System.out.println(StringUtils.swapCase("name"));
		System.out.println(StringUtils.swapCase("AGE"));
		System.out.println(StringUtils.swapCase("Gp Coder"));
	}

}
