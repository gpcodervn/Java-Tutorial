package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class LeftTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringUtils.left("abcdefg", 2)); //ab
		System.out.println(StringUtils.left("abcdefg", 4)); //abcd
		System.out.println(StringUtils.left("abcdefg", 6)); //abcdef

		System.out.println(StringUtils.left(null, 4));      //null
		System.out.println(StringUtils.left("", 4));        //""
		System.out.println(StringUtils.left("", -1));       //""
		System.out.println(StringUtils.left("abcdefg", -1)); //""
	}

}
