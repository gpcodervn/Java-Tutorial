package com.gpcoder;

import java.io.File;

public class FileNameFilterExample {

	public static void main(String[] args) {

		File dir = new File("D:/WorkSpace/gpcoder/data");

		File[] txtFiles = dir.listFiles(new TxtFileNameFilter());

		for (File txtFile : txtFiles) {
			System.out.println(txtFile.getAbsolutePath());
		}
	}

}