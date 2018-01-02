package com.gpcoder.compress.zip;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadZipFileExample {

	public static final String ZIP_FILE = "C:/demo/demo.zip";

	public static void main(String[] args) {
		ZipInputStream zis = null;
		try {
			// Tạo đối tượng ZipInputStream để đọc file zip.
			zis = new ZipInputStream(new FileInputStream(ZIP_FILE));

			ZipEntry entry = null;
			while ((entry = zis.getNextEntry()) != null) {
				if (entry.isDirectory()) {
					System.out.print("Directory: ");
				} else {
					System.out.print("File: ");
				}
				System.out.println(entry.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zis.close();
			} catch (Exception e) {
			}
		}
	}
}
