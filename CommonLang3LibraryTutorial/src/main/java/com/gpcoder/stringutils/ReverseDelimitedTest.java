package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ReverseDelimitedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		System.out.println(StringUtils.reverseDelimited(null, ','));
		System.out.println(StringUtils.reverseDelimited("gp coder", ' '));
		System.out.println(StringUtils.reverseDelimited("(a:b),(c:d),(e:f)", ','));
		System.out.println(StringUtils.reverseDelimited("a,b,c,d", ','));
		System.out.println(StringUtils.reverseDelimited("x+1 > y+3 > z+2", '>'));
	}

}
