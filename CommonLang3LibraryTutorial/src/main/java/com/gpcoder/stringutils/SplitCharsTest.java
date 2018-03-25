package com.gpcoder.stringutils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitCharsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		String [] tokens = StringUtils.split(null, "abcd");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("d = a + b + c", " =+");
		System.out.println(Arrays.toString(tokens));
	
		tokens = StringUtils.split("ababcdabbacd", "ad");
		System.out.println(Arrays.toString(tokens));
	
		tokens = StringUtils.split("gp coder", " ");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("java > commons > lang examples", "> ");
		System.out.println(Arrays.toString(tokens));
	}

}
