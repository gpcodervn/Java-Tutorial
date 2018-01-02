package com.gpcoder.characterstream;

import java.io.CharArrayReader;

public class CharArrayReaderExample {
	public static void main(String[] ag) throws Exception {
		char[] ary = { 'g', 'p', 'c', 'o', 'd', 'e', 'r', '.', 'c', 'o', 'm' };
		CharArrayReader reader = new CharArrayReader(ary);
		int k = 0;
		// Read until the end of a file
		while ((k = reader.read()) != -1) {
			char ch = (char) k;
			System.out.print(ch + " : ");
			System.out.println(k);
		}
	}
}
