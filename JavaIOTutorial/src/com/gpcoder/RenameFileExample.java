package com.gpcoder;

import java.io.File;

public class RenameFileExample {
	public static void main(String[] args) {
		File srcFile = new File("D:/WorkSpace/gpcoder/data/gpcoder.txt");
		File destFile = new File("D:/WorkSpace/gpcoder/data/gpcoder2.txt");

		boolean renamed = srcFile.renameTo(destFile);
		System.out.println("Renamed: " + renamed);
	}
}
