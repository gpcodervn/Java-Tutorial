package com.gpcoder.compress.zip;

import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.CheckedInputStream;
import java.util.zip.Adler32;

public class UnzipWithChecksum {

	public static final String ZIP_FILE = "C:/demo/data-checksum.zip";
	public static final String OUTPUT_FOLDER = "C:/demo/data-checksum";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) {

		// Tạo thư mục Output nếu không tồn tại
		File folder = new File(OUTPUT_FOLDER);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		FileInputStream fis = null;
		ZipInputStream zis = null;
		CheckedInputStream checksum = null;
		try {
			fis = new FileInputStream(ZIP_FILE);

			// Creating input stream that also maintains the checksum of the
			// data which later can be used to validate data integrity.
			checksum = new CheckedInputStream(fis, new Adler32());
			zis = new ZipInputStream(new BufferedInputStream(checksum));

			// Read each entry from the ZipInputStream until no more entry found
			// indicated by a null return value of the getNextEntry() method.
			ZipEntry entry;
			File file;
			OutputStream os;
			String entryName;
			String outFileName;
			while ((entry = zis.getNextEntry()) != null) {
				entryName = entry.getName();
				outFileName = OUTPUT_FOLDER + File.separator + entryName;
				System.out.println("Unzip: " + outFileName);

				file = new File(outFileName);
				if (entry.isDirectory()) {
					// Tạo các thư mục.
					file.mkdirs();
				} else {
					// Tạo các thư mục nếu không tồn tại
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					// Tạo một Stream để ghi dữ liệu vào file.
					os = new FileOutputStream(outFileName);
					int len;
					while ((len = zis.read(BUFFER)) > 0) {
						os.write(BUFFER, 0, len);
					}
					os.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zis.close();
			} catch (Exception e) {
			}
			try {
				zis.close();
			} catch (Exception e) {
			}
		}

		// Print out the checksum value
		if (checksum != null) {
			System.out.println("Checksum = " + checksum.getChecksum().getValue());
		}
	}
}