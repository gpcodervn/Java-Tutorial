package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class CapitalizeTest {

	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.capitalize(null));
		System.out.println(StringUtils.capitalize(""));
		System.out.println(StringUtils.capitalize("name"));
		System.out.println(StringUtils.capitalize("age"));
		System.out.println(StringUtils.capitalize("AGE"));
		System.out.println(StringUtils.capitalize("aGe"));
		System.out.println(StringUtils.capitalize("tutorials from gpcoder"));
	}

}
