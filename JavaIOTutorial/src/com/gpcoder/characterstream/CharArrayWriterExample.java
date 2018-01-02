package com.gpcoder.characterstream;

import java.io.CharArrayWriter;
import java.io.FileWriter;

public class CharArrayWriterExample {
	public static void main(String args[]) throws Exception {
		CharArrayWriter out = new CharArrayWriter();
		out.write("gpcoder.com");
		FileWriter f1 = new FileWriter("data/f1.txt");
		FileWriter f2 = new FileWriter("data/f2.txt");
		FileWriter f3 = new FileWriter("data/f3.txt");
		FileWriter f4 = new FileWriter("data/f4.txt");
		out.writeTo(f1);
		out.writeTo(f2);
		out.writeTo(f3);
		out.writeTo(f4);
		f1.close();
		f2.close();
		f3.close();
		f4.close();
		System.out.println("Success...");
	}
}
