package com.gpcoder;

import java.io.File;

public class FileListExample {
	public static void main(String[] args) {
		System.out.println("File[] listFiles(): ");
		File dir = new File("D:/WorkSpace/gpcoder/data/created1");
		File[] children = dir.listFiles();
		for (File file : children) {
			System.out.println(file.getAbsolutePath());
		}

		System.out.println();

		System.out.println("String[] list(): ");
		String[] paths = dir.list();
		for (String path : paths) {
			System.out.println(path);
		}
	}
}
