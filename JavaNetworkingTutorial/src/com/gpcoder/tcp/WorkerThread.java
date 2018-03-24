package com.gpcoder.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WorkerThread extends Thread {
	private Socket socket;

	public WorkerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("Processing: " + socket);
		try {
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			while (true) {
				int ch = is.read(); // Receive data from client
				if (ch == -1) {
					break;
				}
				os.write(ch); // Send the results to client
			}
		} catch (IOException e) {
			System.err.println("Request Processing Error: " + e);
		}
		System.out.println("Complete processing: " + socket);
	}
}