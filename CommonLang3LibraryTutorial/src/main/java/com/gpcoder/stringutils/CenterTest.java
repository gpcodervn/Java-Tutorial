package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class CenterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.center("GPC", 5, "*")); //(string, size, padStr)
		System.out.println(StringUtils.center("GPC", 6, "*"));
		System.out.println(StringUtils.center("GPC", 7, "*"));
		System.out.println(StringUtils.center("GPC", 8, "*"));
		System.out.println(StringUtils.center("GPC", 9, "*"));
		
		System.out.println(StringUtils.center("GPC", 4, "*"));
		System.out.println(StringUtils.center("GPC", 3, "*"));
		System.out.println(StringUtils.center("GPC", 2, "*"));
	}

}
