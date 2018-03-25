package com.gpcoder.stringutils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitCharTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		String [] tokens = StringUtils.split(null, ':');
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("a+b+c", '+');
		System.out.println(Arrays.toString(tokens));
	
		tokens = StringUtils.split("ababcdabbacd", 'a');
		System.out.println(Arrays.toString(tokens));
	
		tokens = StringUtils.split("gp coder", ' ');
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("java>commons>lang", '>');
		System.out.println(Arrays.toString(tokens));
	}

}
