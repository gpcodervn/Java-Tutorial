package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class JoinSeparatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.join(new Object [] {}, ':'));
		System.out.println(StringUtils.join(new Object [] { "a", "b", "c", "d" }, '+'));
		System.out.println(StringUtils.join(new Object [] { "one", "", null, "two" }, '.'));
	}

}
