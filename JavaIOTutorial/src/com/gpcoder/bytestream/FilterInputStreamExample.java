package com.gpcoder.bytestream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class FilterInputStreamExample {
	public static void main(String[] args) throws IOException {
		FileInputStream file = null;
		FilterInputStream filter = null;
		try {
			file = new FileInputStream(new File("data/test.txt"));
			filter = new BufferedInputStream(file);

			int k = 0;
			while ((k = filter.read()) != -1) {
				System.out.print((char) k);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		file.close();
		filter.close();
	}
}
