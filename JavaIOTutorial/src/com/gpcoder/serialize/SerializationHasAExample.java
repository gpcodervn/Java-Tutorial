package com.gpcoder.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationHasAExample {
	public static void main(String args[]) throws Exception {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("data/engineer.txt"));
			Company company = new Company(1, "Gp Coder");
			Address address = new Address("3/2 Street", "CT", "NK");
			company.setAddress(address);
			oos.writeObject(company);
			oos.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			oos.close();
		}
		System.out.println("success...");
	}
}
