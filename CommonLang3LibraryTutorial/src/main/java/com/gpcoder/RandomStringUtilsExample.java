package com.gpcoder;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsExample {

	public static void main(String[] args) {

		System.out.println(RandomStringUtils.random(4)); // 𩭯𨳅
		System.out.println(RandomStringUtils.random(6)); // 𣐸㚔쬩́㽩

		System.out.println(RandomStringUtils.randomAscii(4)); // qe51
		System.out.println(RandomStringUtils.randomAscii(6)); // MqQ^X\

		System.out.println(RandomStringUtils.randomNumeric(4)); // 9808
		System.out.println(RandomStringUtils.randomNumeric(6)); // 338756

		System.out.println(RandomStringUtils.randomAlphabetic(4)); // kvMu
		System.out.println(RandomStringUtils.randomAlphabetic(6)); // PeykyQ

		System.out.println(RandomStringUtils.randomAlphanumeric(4)); // MavC
		System.out.println(RandomStringUtils.randomAlphanumeric(6)); // fR2BEf

		String input = "abcd1234!@#$%^&*()-=_+;:<>,.?/";
		System.out.println(RandomStringUtils.random(4, input)); // 1)+(
		System.out.println(RandomStringUtils.random(6, input)); // -c=,a,
	}
}
