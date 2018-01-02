package com.gpcoder.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamExample {
	public static void main(String args[]) throws Exception {
		FileInputStream input1 = null;
		FileInputStream input2 = null;
		SequenceInputStream inst = null;
		try {
			input1 = new FileInputStream("data/test1.txt");
			input2 = new FileInputStream("data/test2.txt");
			inst = new SequenceInputStream(input1, input2);
			int j;
			while ((j = inst.read()) != -1) {
				System.out.print((char) j);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			inst.close();
			input1.close();
			input2.close();
		}
	}
}
