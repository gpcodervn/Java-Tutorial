package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ReplaceCharsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String data = "gp coder";
		String searchChars = "abcdefghijklmnopqrstuvwxyz";
		String replaceChars = searchChars.toUpperCase();
		
		System.out.println(StringUtils.replaceChars(data, searchChars, replaceChars));
	}

}
