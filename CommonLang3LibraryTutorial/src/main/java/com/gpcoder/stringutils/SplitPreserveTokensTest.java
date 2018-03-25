package com.gpcoder.stringutils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitPreserveTokensTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		String [] tokens = StringUtils.splitPreserveAllTokens(null);
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("gp coder");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens(" java ");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("java   tutorials");
		System.out.println(Arrays.toString(tokens));
		   
		// delimiters
		tokens = StringUtils.splitPreserveAllTokens(null, "abc");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("", "abc");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("gp coder", "abc");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("abcabbacabbabcabc", "c");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.splitPreserveAllTokens("ab++cd+ef+g++h", "+");
		System.out.println(Arrays.toString(tokens));
	}

}
