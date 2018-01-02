package com.gpcoder;

import java.io.File;

public class MakeDirExample {

	public static void main(String[] args) {
		File dir = new File("D:/WorkSpace/gpcoder/data/created1/child1");
		System.out.println("Pathname: " + dir.getAbsolutePath());
		System.out.println("Path exists:  " + dir.exists());
		System.out.println("Parent Path exists: " + dir.getParentFile().exists());

		// Với mkdir(), thư mục chỉ được tạo ra nếu thư mục cha tồn tại.
		boolean created = dir.mkdir();
		System.out.println("Directory created: " + created);

		System.out.println("--------------------");

		File dir2 = new File("D:/WorkSpace/gpcoder/data/created2/child2");
		System.out.println("Pathname: " + dir2.getAbsolutePath());
		System.out.println("File exists: " + dir2.exists());

		// Với mkdirs(), thư mục được tạo ra bao gồm cả các thư mục cha nếu nó không tồn tại.
		created = dir2.mkdirs();
		System.out.println("Directory created: " + created);
	}
}