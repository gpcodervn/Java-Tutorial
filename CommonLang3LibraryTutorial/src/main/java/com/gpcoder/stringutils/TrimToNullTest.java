package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class TrimToNullTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.trimToNull(null));
		System.out.println(StringUtils.trimToNull(""));
		System.out.println(StringUtils.trimToNull(" "));
		System.out.println(StringUtils.trimToNull(" GPC     "));
	}

}
