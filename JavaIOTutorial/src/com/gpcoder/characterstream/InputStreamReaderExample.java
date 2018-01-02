package com.gpcoder.characterstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws IOException {

		// Tạo một binary Stream (luồng nhị phân), để đọc file.
		InputStream in = new FileInputStream("data/test.txt");

		// Tạo một Character stream (luồng ký tự) với mã hóa (encoding) là UTF-8.
		Reader reader = new InputStreamReader(in, "UTF-8");

		int i = 0;
		// Đọc lần lượt từng ký tự.
		while ((i = reader.read()) != -1) {
			// Ép kiểu (cast) thành một ký tự và in ra màn hình.
			System.out.println((char) i + " " + i);
		}
		reader.close();
	}
}
