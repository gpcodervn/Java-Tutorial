package com.gpcoder.stringutils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class JoinIteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> data = Arrays.asList("ONE", "TWO", "THREE", "FOUR");
		System.out.println(StringUtils.join(data, "!!!"));
		
		List<Integer> ints = Arrays.asList(1, 2, 3, 4);
		System.out.println(StringUtils.join(ints, "*"));
	}

}
