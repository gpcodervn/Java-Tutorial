package com.gpcoder.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationStaticExample {
	public static void main(String args[]) throws Exception {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data/employee.txt"));
			Employee employee = new Employee(1, "Gp Coder");
			oos.writeObject(employee);
			oos.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			oos.close();
		}
		System.out.println("success...");
	}

}
