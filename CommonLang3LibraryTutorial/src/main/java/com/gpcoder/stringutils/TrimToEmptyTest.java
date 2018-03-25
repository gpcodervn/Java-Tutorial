package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class TrimToEmptyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.trimToEmpty(null));          //""
		System.out.println(StringUtils.trimToEmpty(""));			//""
		System.out.println(StringUtils.trimToEmpty(" "));			//""
		System.out.println(StringUtils.trimToEmpty(" GPC     "));   //GPC
	}

}
