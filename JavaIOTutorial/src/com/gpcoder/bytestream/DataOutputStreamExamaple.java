package com.gpcoder.bytestream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStreamExamaple {

	public static void main(String[] args) throws IOException {

		int id = 1;
		String name = "gpcoder.com";

		OutputStream file = new FileOutputStream("data/test3.txt");
		DataOutputStream data = new DataOutputStream(file);
		
		data.writeInt(id);
		data.writeUTF(name);
		
		data.flush();
		data.close();
		System.out.println("Succcess...");
	}
}
