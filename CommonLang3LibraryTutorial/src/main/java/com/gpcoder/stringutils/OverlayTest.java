package com.gpcoder.stringutils;

import org.apache.commons.lang3.StringUtils;

public class OverlayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String credit_card = "4840282024288624";
		System.out.println(StringUtils.overlay(credit_card, "****", 0, 4));
		System.out.println(StringUtils.overlay(credit_card, "****", 2, 4));
		System.out.println(StringUtils.overlay(credit_card, "****", 4, 8));
		System.out.println(StringUtils.overlay(credit_card, "****", 8, 12));
	}

}
