package com.gpcoder.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFolderExample {

	public static void main(String[] args) throws IOException {
		File sourceDir = new File("E:/TestCopy");
		File destDir = new File("D:/Copy");
		copyDirectory(sourceDir, destDir);
	}

	public static void copyDirectory(File sourceDir, File destDir) throws IOException {
		// creates the destination directory if it does not exist
		if (!destDir.exists()) {
			destDir.mkdirs();
		}

		// throws exception if the source does not exist
		if (!sourceDir.exists()) {
			throw new IllegalArgumentException("sourceDir does not exist");
		}

		// throws exception if the arguments are not directories
		if (sourceDir.isFile() || destDir.isFile()) {
			throw new IllegalArgumentException("Either sourceDir or destDir is not a directory");
		}

		doCopyDirectoryImpl(sourceDir, destDir);
	}

	private static void doCopyDirectoryImpl(File sourceDir, File destDir) throws IOException {
		File[] items = sourceDir.listFiles();
		if (items != null && items.length > 0) {
			for (File anItem : items) {
				if (anItem.isDirectory()) {
					// create the directory in the destination
					File newDir = new File(destDir, anItem.getName());
					System.out.println("CREATED DIR: " + newDir.getAbsolutePath());
					newDir.mkdir();

					// copy the directory (recursive call)
					doCopyDirectoryImpl(anItem, newDir);
				} else {
					// copy the file
					File destFile = new File(destDir, anItem.getName());
					doCopySingleFile(anItem, destFile);
				}
			}
		}
	}

	private static void doCopySingleFile(File sourceFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel sourceChannel = null;
		FileChannel destChannel = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream(sourceFile);
			fos = new FileOutputStream(destFile);

			sourceChannel = fis.getChannel();
			destChannel = fos.getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (sourceChannel != null) {
				sourceChannel.close();
			}
			if (destChannel != null) {
				destChannel.close();
			}
		}
	}

}
