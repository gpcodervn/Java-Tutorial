package com.gpcoder.compress.gzip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GZipDecompressExample {

	public static final String INPUT_FILE = "C:/demo/gzip-output.gz";
	public static final String OUTPUT_FILE = "C:/demo/note.txt";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) throws IOException {
		// Create a file input stream to read the source file.
		FileInputStream fis = new FileInputStream(INPUT_FILE);

		// Create a gzip input stream to decompress the source
		// file defined by the file input stream.
		GZIPInputStream gzis = new GZIPInputStream(fis);

		// Create file output stream where the decompress result
		// will be stored.
		FileOutputStream fos = new FileOutputStream(OUTPUT_FILE);

		// Read from the compressed source file and write the
		// decompress file.
		int length;
		while ((length = gzis.read(BUFFER)) > 0) {
			fos.write(BUFFER, 0, length);
		}

		// Close the resources.
		fos.close();
		gzis.close();
		fis.close();
		System.out.println("Done!!!");
	}
}