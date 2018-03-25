package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class ReverseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(StringUtils.reverse(null)); // null
		System.out.println(StringUtils.reverse("")); // ""
		System.out.println(StringUtils.reverse("  ")); // " "
		System.out.println(StringUtils.reverse("java")); // avaj
		System.out.println(StringUtils.reverse("gp coder")); // redoc pg
	}

}
