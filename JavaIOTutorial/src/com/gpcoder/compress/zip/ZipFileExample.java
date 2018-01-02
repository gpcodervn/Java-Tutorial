package com.gpcoder.compress.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileExample {
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[1024];

		OutputStream fos = new FileOutputStream("C:/demo/demo.zip");
		ZipOutputStream zos = new ZipOutputStream(fos);
		ZipEntry ze = new ZipEntry("sql.log"); // file name
		zos.putNextEntry(ze);
		
		FileInputStream in = new FileInputStream("C:/demo/data/sql.log");
		int len;
		while ((len = in.read(buffer)) > 0) {
			zos.write(buffer, 0, len);
		}
		in.close();
		
		zos.closeEntry();
		zos.close(); // remember close it
		System.out.println("Done");
	}
}
