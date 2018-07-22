package com.gpcoder.base64;

import java.util.Base64;

public class Base64Example2 {

	public static void main(String[] args) {
		String url = "https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/";
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes());
		System.out.println(encodedUrl);
		// aHR0cHM6Ly9ncGNvZGVyLmNvbS80MTQ0LWJhc2U2NC1lbmNvZGluZy12YS1kZWNvZGluZy10cm9uZy1qYXZhLTgv

		byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
		String decodedUrl = new String(decodedBytes);
		System.out.println(decodedUrl);
		// https://gpcoder.com/4144-base64-encoding-va-decoding-trong-java-8/
	}
}
