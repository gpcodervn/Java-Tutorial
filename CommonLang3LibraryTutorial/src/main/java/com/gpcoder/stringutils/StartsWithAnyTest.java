package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class StartsWithAnyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		String [] str = { "ab", "xyz", "1234" };
		
		System.out.println(StringUtils.startsWithAny(null, str));
		System.out.println(StringUtils.startsWithAny("", str));
		
		System.out.println(StringUtils.startsWithAny("123456", str));
		System.out.println(StringUtils.startsWithAny("abcdefg", str));
		System.out.println(StringUtils.startsWithAny("123xyz456", str));
		
		System.out.println(StringUtils.startsWithAny("xyz", str));
		System.out.println(StringUtils.startsWithAny("pqr", str));
	}

}
