package com.gpcoder.characterstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String args[]) throws Exception {
		FileOutputStream fout = new FileOutputStream("data/test.txt");
		PrintStream pout = new PrintStream(fout);
		pout.println(2017);
		pout.println("gpcoder.com");
		pout.println("Java I/O Tutorials");
		pout.close();
		fout.close();
		System.out.println("Success...");
	}
}
