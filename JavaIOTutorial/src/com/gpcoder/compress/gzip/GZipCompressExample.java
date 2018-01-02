package com.gpcoder.compress.gzip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZipCompressExample {

	public static final String OUTPUT_FILE = "C:/demo/gzip-output.gz";
	public static final String INPUT_FILE = "C:/demo/data/note.txt";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) throws IOException {
		// Create a file output stream the write the gzip result into
		// a specified file name.
		FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);

		// Create a gzip output stream object with file output stream
		// as the argument.
		GZIPOutputStream gzos = new GZIPOutputStream(fos);

		// Create a file input stream of the file that is going to be
		// compressed.
		FileInputStream fis = new FileInputStream(INPUT_FILE);

		// Read all the content of the file input stream and write it
		// to the gzip output stream object.
		int length;
		while ((length = fis.read(BUFFER)) > 0) {
			gzos.write(BUFFER, 0, length);
		}

		// Finish file compressing and close all streams.
		fis.close();
		gzos.finish();
		gzos.close();
		System.out.println("Done!!!");
	}
}