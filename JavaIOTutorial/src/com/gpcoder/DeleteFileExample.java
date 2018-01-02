package com.gpcoder;

import java.io.File;

public class DeleteFileExample {
	public static void main(String[] args) {
		File file = new File("D:/WorkSpace/gpcoder/data/test2.txt");
		if (file.delete()) {
			System.out.println(file.getName() + " is deleted!");
		} else {
			System.out.println("Delete operation is failed.");
		}
	}
}
