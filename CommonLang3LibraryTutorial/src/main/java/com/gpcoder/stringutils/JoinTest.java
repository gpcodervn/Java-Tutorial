package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class JoinTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.out.println(StringUtils.join(null));
		System.out.println(StringUtils.join(new Object [] {}));
		System.out.println(StringUtils.join("a", "b", "c", "d"));
		System.out.println(StringUtils.join("one", "", null, "two"));
	}

}
