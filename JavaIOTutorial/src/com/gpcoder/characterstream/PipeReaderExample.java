package com.gpcoder.characterstream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;

public class PipeReaderExample {
	private Reader pipedReader;

	public static void main(String[] args) throws IOException, InterruptedException {
		new PipeReaderExample().test();
	}

	private void test() throws IOException, InterruptedException {
		// Tạo một 'pipedWriter',
		PipedWriter pipedWriter = new PipedWriter();

		// Dữ liệu ghi vào 'pipedWriter'
		// sẽ tự động xuất hiện tại 'pipedReader'.
		pipedReader = new PipedReader(pipedWriter);

		new ThreadRead().start();

		char[] chs = new char[] { 'a', 'a', 'b', 'c', 'e' };

		// Ghi dữ liệu vào 'pipedWriter'.
		for (char ch : chs) {
			pipedWriter.write(ch);
			Thread.sleep(1000);
		}
		pipedWriter.close();
	}

	// Một Thread đọc dữ liệu xuất hiện trên 'pipedReader'.
	class ThreadRead extends Thread {
		@Override
		public void run() {
			try {
				int data = 0;
				while ((data = pipedReader.read()) != -1) {
					System.out.println((char) data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeQuietly(pipedReader);
			}
		}
	}

	private void closeQuietly(Reader is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}
}
