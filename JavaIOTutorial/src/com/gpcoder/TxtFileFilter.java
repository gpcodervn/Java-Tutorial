package com.gpcoder;

import java.io.File;
import java.io.FileFilter;

public class TxtFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {

		if (!pathname.isFile()) {
			return false;
		}

		if (pathname.getAbsolutePath().endsWith(".txt")) {
			return true;
		}

		return false;
	}

}