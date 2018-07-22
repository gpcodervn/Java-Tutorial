package com.gpcoder.base64;

import java.util.Base64;
import java.util.UUID;

public class Base64Example3 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int count = 0; count < 10; ++count) {
			sb.append(UUID.randomUUID().toString());
		}

		String str = sb.toString();
		String encodedMime = Base64.getMimeEncoder().encodeToString(str.getBytes());
		System.out.println(encodedMime);
		
		byte[] decodedBytes = Base64.getMimeDecoder().decode(encodedMime);
		String decodedMime = new String(decodedBytes);
		System.out.println(decodedMime.equals(str)); // true
	}
}
