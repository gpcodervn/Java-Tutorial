package com.gpcoder.stringutils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitWholeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		String [] tokens = StringUtils.splitByWholeSeparator(null, "@@@");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitByWholeSeparator("user@@@pwd@@@key", "@@@");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitByWholeSeparator("user@@@pwd@@@key", "@@");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitByWholeSeparator("a+-+b+-+c+-+d", "+-+");
		System.out.println(Arrays.toString(tokens));

		tokens = StringUtils.splitByWholeSeparator("a:b:c:d", ":");
		System.out.println(Arrays.toString(tokens));

	}

}
