package com.gpcoder.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {
	public static void main(String args[]) throws Exception {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data/student.txt"));
			Student student = (Student) ois.readObject();
			System.out.println(student);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
	}
}
