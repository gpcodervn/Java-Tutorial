package com.gpcoder.characterstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterExample {

	public static void main(String[] args) throws IOException {

		// Tạo một OutputStream (luồng đầu ra) để ghi dữ liệu vào file.
		OutputStream out = new FileOutputStream("data/test.txt");

		// Tạo một Character Stream (luồng ghi ký tự) với mã hóa (encoding) là UTF-8.
		Writer writer = new OutputStreamWriter(out, "UTF-8");

		String s = "Lập trình Java";
		writer.write(s);
		writer.close();
	}
}
