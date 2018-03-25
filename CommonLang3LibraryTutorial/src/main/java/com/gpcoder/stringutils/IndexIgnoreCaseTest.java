package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class IndexIgnoreCaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.indexOfIgnoreCase(null, null));
		System.out.println(StringUtils.indexOfIgnoreCase("DCABCABAABAAB", "ab"));
		System.out.println(StringUtils.indexOfIgnoreCase("DCABCABAABAAB", "AB"));
		System.out.println(StringUtils.indexOfIgnoreCase("CABCDABCDABCD", "ABC"));
	}

}
