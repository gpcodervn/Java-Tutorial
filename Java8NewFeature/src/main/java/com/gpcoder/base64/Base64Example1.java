package com.gpcoder.base64;

import java.util.Base64;

public class Base64Example1 {

	public static void main(String[] args) {
		String str = "GP Coder";
		String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println(encodedString); // R1AgQ29kZXI=

		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		System.out.println(decodedString); // GP Coder
		
		String encodedStringWithoutPadding = 
				  Base64.getEncoder().withoutPadding().encodeToString(str.getBytes());
		System.out.println(encodedStringWithoutPadding); // R1AgQ29kZXI
	}
}
