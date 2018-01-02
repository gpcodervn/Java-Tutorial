package com.gpcoder.bytestream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class FilterOutputStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream file = null;
		FilterOutputStream filter = null;
		try {
			file = new FileOutputStream(new File("data/test.txt"));
			filter = new FilterOutputStream(file);
			String s = "gpcoder.com";
			byte b[] = s.getBytes();
			filter.write(b);
			filter.flush();
			System.out.println("Success...");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			filter.close();
			file.close();
		}
	}
}
