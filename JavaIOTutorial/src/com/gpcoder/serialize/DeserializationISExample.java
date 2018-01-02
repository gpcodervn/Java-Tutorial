package com.gpcoder.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationISExample {
	public static void main(String args[]) throws Exception {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data/engineer.txt"));
			Engineer engineer = (Engineer) ois.readObject();
			System.out.println(engineer);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
	}
}
