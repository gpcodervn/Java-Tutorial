package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class DefaultStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    	 
		//StringUtils.defaultString(String str)
		System.out.println(StringUtils.defaultString(null));   //empty
		System.out.println(StringUtils.defaultString(""));     //empty
		System.out.println(StringUtils.defaultString("java")); //java

		//StringUtils.defaultString(String str, String defaultStr)
		System.out.println(StringUtils.defaultString(null, "N/A"));  //N/A
		System.out.println(StringUtils.defaultString("", "N/A"));    //empty
		System.out.println(StringUtils.defaultString("java", "N/A"));//java
	}

}
