package com.gpcoder;

import java.io.File;

public class RecursiveFileExample {

	public static void main(String[] args) {
		RecursiveFileExample example = new RecursiveFileExample();
		File dir = new File("D:\\WorkSpace\\gpcoder\\data");
		example.listChild(dir, 0);
	}

	private void listChild(File file, int level) {

		if (file.isDirectory()) { // Dừng nếu là tập tin
			System.out.println(getPadding(level) + " - " + file.getName());
			File[] children = file.listFiles();
			for (File child : children) {
				this.listChild(child, level + 1); // Gọi đệ quy
			}
		} else {
			System.out.println(getPadding(level) + " + " + file.getName());
		}

	}

	private String getPadding(int level) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= level; i++) {
			sb.append("    "); // Thêm dấu tab.
		}
		return sb.toString();
	}

}
