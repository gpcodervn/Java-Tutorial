package com.gpcoder;

import java.io.File;

public class RenameFolderExample {
	public static void main(String[] args) {
		File srcFile = new File("D:/WorkSpace/gpcoder/data/test1.txt");
		File destFile = new File("D:/WorkSpace/gpcoder/data/created4/gpcoder.txt");

		if (!srcFile.exists()) {
			System.out.println("Src File doest not exists");
			return;
		}

		// Tạo thư mục cha của file đích
		destFile.getParentFile().mkdirs();

		boolean renamed = srcFile.renameTo(destFile);
		System.out.println("Renamed: " + renamed); // true
	}
}
