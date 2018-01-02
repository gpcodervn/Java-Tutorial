package com.gpcoder.bytestream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStreamExample {
	private InputStream pipedInputStream;

	public static void main(String[] args) throws IOException, InterruptedException {
		new PipeStreamExample().test();
	}

	private void test() throws IOException, InterruptedException {
		// Tạo một 'pipedOutputStream',
		PipedOutputStream pipedOutputStream = new PipedOutputStream();

		// Dữ liệu ghi vào 'pipedOutputStream'
		// sẽ tự động xuất hiện tại 'pipedInputStream'.
		pipedInputStream = new PipedInputStream(pipedOutputStream);

		new ThreadRead().start();

		char[] chs = new char[] { 'a', 'a', 'b', 'c', 'e' };

		// Ghi dữ liệu vào 'pipedOutputStream'.
		for (char ch : chs) {
			pipedOutputStream.write(ch);
			Thread.sleep(1000);
		}
		pipedOutputStream.close();
	}

	// Một Thread đọc dữ liệu xuất hiện trên 'pipedInputStream'.
	class ThreadRead extends Thread {

		@Override
		public void run() {
			try {
				int data = 0;
				while ((data = pipedInputStream.read()) != -1) {
					System.out.println((char) data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeQuietly(pipedInputStream);
			}
		}
	}

	private void closeQuietly(InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}
}
