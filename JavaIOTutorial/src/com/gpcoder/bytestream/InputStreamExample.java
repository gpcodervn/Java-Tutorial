package com.gpcoder.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

	public static void main(String[] args) throws IOException {

		// Tạo một đối tượng InputStream: Luồng đọc một file.
		InputStream is = new FileInputStream("data/test.txt");

		int i = -1;

		// Đọc lần lượt các byte (8bit) trong luồng và lưu vào biến i
		// Khi đọc ra giá trị -1 nghĩa là kết thúc luồng.
		while ((i = is.read()) != -1) {
			System.out.println((char) i);
		}
		is.close();
	}
}
