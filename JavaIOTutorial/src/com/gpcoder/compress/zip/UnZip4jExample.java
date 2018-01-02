package com.gpcoder.compress.zip;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class UnZip4jExample {

	public static final String ZIP_FILE = "C:/demo/zip4jFolderExample.zip";
	public static final String DESTINATION_FOLDER = "C:/demo/outputZip4j";
	public static final String PASSWORD = "yourPassword";
	
	public static void main(String[] args) throws ZipException {
		ZipFile zipFile = new ZipFile(ZIP_FILE);
		if (zipFile.isEncrypted()) {
			zipFile.setPassword(PASSWORD);
		}
		zipFile.extractAll(DESTINATION_FOLDER);
		System.out.println("Done!!!");
	}
}
