package com.gpcoder.compress.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFileExample {

	public static final String ZIP_FILE = "C:\\demo\\demo.zip";
	public static final String OUTPUT_FOLDER = "C:\\demo\\output";
	public static final byte[] BUFFER = new byte[1024];

	public static void main(String[] args) {
		// Tạo thư mục Output nếu không tồn tại
		File folder = new File(OUTPUT_FOLDER);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		ZipInputStream zis = null;
		try {
			zis = new ZipInputStream(new FileInputStream(ZIP_FILE));

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
		}
	}
}
