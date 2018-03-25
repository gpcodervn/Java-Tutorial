package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class EndsWithAnyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		String [] searchStrings = { "ab", "xyz", "1234" };
		
		System.out.println(StringUtils.endsWithAny(null, searchStrings));
		System.out.println(StringUtils.endsWithAny("", searchStrings));
		
		System.out.println(StringUtils.endsWithAny("653218901234", searchStrings));
		System.out.println(StringUtils.endsWithAny("defgcab", searchStrings));
		System.out.println(StringUtils.endsWithAny("123xyz456", searchStrings));
		
		System.out.println(StringUtils.endsWithAny("xyz", searchStrings));
		System.out.println(StringUtils.endsWithAny("pqr", searchStrings));
	}

}
