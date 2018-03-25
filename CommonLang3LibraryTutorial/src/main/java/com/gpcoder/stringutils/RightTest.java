package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class RightTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringUtils.right("abcdefg", 2)); //fg
		System.out.println(StringUtils.right("abcdefg", 4)); //defg
		System.out.println(StringUtils.right("abcdefg", 6)); //bcdefg

		System.out.println(StringUtils.right(null, 4));        //null
		System.out.println(StringUtils.right("", 4));          //""
		System.out.println(StringUtils.right("", -1));         //""
		System.out.println(StringUtils.right("abcdefg", -1));  //""
	}

}
