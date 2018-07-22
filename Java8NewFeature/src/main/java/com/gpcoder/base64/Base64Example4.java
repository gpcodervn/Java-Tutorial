package com.gpcoder.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Example4 {

	public static void main(String[] args) {
		base();
		url();
	}

	private static void base() {
		Base64 base64 = new Base64();

		String str = "GP Coder";
		String encodedString = new String(base64.encode(str.getBytes()));
		System.out.println(encodedString); // R1AgQ29kZXI=

		byte[] decodedBytes = encodedString.getBytes();
		String decodedString = new String(base64.decode(decodedBytes));
		System.out.println(decodedString); // GP Coder
	}

	private static void url() {
		Base64 base64 = new Base64(true);
		String url = "https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/";
		String encodedString = new String(base64.encode(url.getBytes()));
		System.out.println(encodedString);
		// aHR0cHM6Ly9ncGNvZGVyLmNvbS80MTQ0LWJhc2U2NC1lbmNvZGluZy12YS1kZWNvZGluZy10cm9u
		// Zy1qYXZhLTgv

		byte[] decodedBytes = encodedString.getBytes();
		String decodedString = new String(base64.decode(decodedBytes));
		System.out.println(decodedString);
		// https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/
	}
}
