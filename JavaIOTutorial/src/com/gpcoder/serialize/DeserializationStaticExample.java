package com.gpcoder.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationStaticExample {
	public static void main(String args[]) throws Exception {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("data/employee.txt"));
			Employee employee = (Employee) ois.readObject();
			System.out.println(employee);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
	}
}
