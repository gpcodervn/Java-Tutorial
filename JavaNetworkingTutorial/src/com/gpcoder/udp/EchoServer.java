package com.gpcoder.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {

	public final static int SERVER_PORT = 7; // Cổng mặc định của Echo Server
	public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận

	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
			ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
			System.out.println("Server started ");
			System.out.println("Waiting for messages from Client ... ");

			while (true) { // Tạo gói tin nhận
				DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
				ds.receive(incoming); // Chờ nhận gói tin gởi đến

				// Lấy dữ liệu khỏi gói tin nhận
				String message = new String(incoming.getData(), 0, incoming.getLength());
				System.out.println("Received: " + message);

				// Tạo gói tin gởi chứa dữ liệu vừa nhận được
				DatagramPacket outsending = new DatagramPacket(message.getBytes(), incoming.getLength(),
						incoming.getAddress(), incoming.getPort());
				ds.send(outsending);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ds != null) {
				ds.close();
			}
		}
	}
}
