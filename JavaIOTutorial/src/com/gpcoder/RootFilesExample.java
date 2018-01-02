package com.gpcoder;

import java.io.File;

public class RootFilesExample {
	public static void main(String[] args) {
		File[] roots = File.listRoots();
		for (File root : roots) {
			System.out.println(root.getAbsolutePath());
		}
	}
}
