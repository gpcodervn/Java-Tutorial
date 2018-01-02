package com.gpcoder.characterstream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterExample {
	public static void main(String[] args) throws Exception {
		FileWriter writer = new FileWriter("data/test.txt");
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write("gpcoder.com");
		buffer.close();
		System.out.println("Success...");
	}
}
