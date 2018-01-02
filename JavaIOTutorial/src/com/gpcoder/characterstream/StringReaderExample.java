package com.gpcoder.characterstream;

import java.io.StringReader;

public class StringReaderExample {
	public static void main(String[] args) throws Exception {
		String srg = "gpcoder.com";
		StringReader reader = new StringReader(srg);
		int k = 0;
		while ((k = reader.read()) != -1) {
			System.out.print((char) k);
		}
	}
}
