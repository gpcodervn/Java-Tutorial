package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RemoveTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.remove(null, "++"));
		System.out.println(StringUtils.remove("", "++"));
		System.out.println(StringUtils.remove("gp coder", " "));
		System.out.println(StringUtils.remove("a+-+b+-+c+-+d", "+-+"));
	}

}
