package com.gpcoder.characterstream;

import java.io.FileWriter;

public interface FileWriterExample {
	public static void main(String args[]) {
		try {
			FileWriter fw = new FileWriter("data/test.txt");
			fw.write("gpcoder.com");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...");
	}
}
