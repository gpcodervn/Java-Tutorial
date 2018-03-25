package com.gpcoder.stringutils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		String [] tokens = StringUtils.split(null);
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split("gp coder");
		System.out.println(Arrays.toString(tokens));
		
		tokens = StringUtils.split(" java ");
		System.out.println(Arrays.toString(tokens));
	}

}
