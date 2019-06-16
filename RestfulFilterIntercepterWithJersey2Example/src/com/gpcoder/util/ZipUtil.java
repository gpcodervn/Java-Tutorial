package com.gpcoder.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

/**
 * http://notepad2.blogspot.com/2012/07/java-detect-if-stream-or-file-is-zip.html
 */
public class ZipUtil {

	private static final byte[] MAGIC = { 'P', 'K', 0x3, 0x4 };

	private ZipUtil() {
		super();
	}

	/**
	 * The method to decompress a input stream if a input stream is a gzip archive.
	 * 
	 * @param in the input stream to be decompressed.
	 * @return
	 */
	public static InputStream decompressStream(InputStream input) {
		try {
			// we need a pushbackstream to look ahead
			PushbackInputStream pb = new PushbackInputStream(input, 2);
			byte[] signature = new byte[2];
			int len = pb.read(signature); // read the signature
			pb.unread(signature, 0, len); // push back the signature to the stream
			if (signature[0] == (byte) 0x1f && signature[1] == (byte) 0x8b) {
				// check if matches standard gzip magic number
				return new GZIPInputStream(pb);
			}
			return pb;
		} catch (Exception e) {
			return input;
		}
	}

	/**
	 * The method to test if a input stream is a zip archive.
	 * 
	 * @param in the input stream to test.
	 * @return
	 */
	public static boolean isZipStream(InputStream in) {
		if (!in.markSupported()) {
			in = new BufferedInputStream(in);
		}
		boolean isZip = true;
		try {
			in.mark(MAGIC.length);
			for (int i = 0; i < MAGIC.length; i++) {
				if (MAGIC[i] != (byte) in.read()) {
					isZip = false;
					break;
				}
			}
			in.reset();
		} catch (IOException e) {
			isZip = false;
		}
		return isZip;
	}

	/**
	 * Test if a file is a zip file.
	 * 
	 * @param file the file to test.
	 * @return
	 */
	public static boolean isZipFile(File file) {

		boolean isZip = true;
		byte[] buffer = new byte[MAGIC.length];
		try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
			raf.readFully(buffer);
			for (int i = 0; i < MAGIC.length; i++) {
				if (buffer[i] != MAGIC[i]) {
					isZip = false;
					break;
				}
			}
		} catch (Exception e) {
			isZip = false;
		}
		return isZip;
	}
}