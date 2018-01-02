package com.gpcoder.bytestream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamExample {

	public static void main(String[] args) throws IOException {

		InputStream input = new FileInputStream("data/test3.txt");
		DataInputStream inst = new DataInputStream(input);

		int id = inst.readInt();
		String name = inst.readUTF();

		System.out.println("Id: " + id + ", Name: " + name);

		inst.close();
	}
}
