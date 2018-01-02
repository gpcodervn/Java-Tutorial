package com.gpcoder.compress.zip;

import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class Zip4jExample {

	public static final String OUTPUT_ZIP_FILE = "C:/demo/zip4jFolderExample.zip";
	public static final String SOURCE_FOLDER = "C:/demo/data";
	public static final String PASSWORD = "yourPassword";

	public static void main(String[] args) throws ZipException {
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		if (PASSWORD.length() > 0) {
			parameters.setEncryptFiles(true);
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
			parameters.setPassword(PASSWORD);
		}

		// Zip files inside a folder
		// An exception will be thrown if the output file already exists
		File outputFile = new File(OUTPUT_ZIP_FILE);
		ZipFile zipFile = new ZipFile(outputFile);

		File sourceFolder = new File(SOURCE_FOLDER);
		// false - indicates archive should not be split and 0 is split length
		zipFile.createZipFileFromFolder(sourceFolder, parameters, false, 0);

		// Zip a single file
		// An exception will be thrown if the output file already exists
		outputFile = new File("C:/demo/zip4jFileExample.zip");
		zipFile = new ZipFile(outputFile);
		File sourceFile = new File("C:/demo/data/sql.log");
		zipFile.addFile(sourceFile, parameters);
		System.out.println("Done!!!");
	}
}
