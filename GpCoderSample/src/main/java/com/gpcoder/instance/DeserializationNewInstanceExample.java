package com.gpcoder.instance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationNewInstanceExample {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		File file = File.createTempFile("student", "txt");
		serialize(file);
		deserialize(file);
	}

	private static void serialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			StudentSerializable student = new StudentSerializable(1, "gpcoder");
			oos.writeObject(student);
			oos.flush();
			System.out.println("Serialized");
		}
	}

	private static void deserialize(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			StudentSerializable student = (StudentSerializable) ois.readObject();
			System.out.println(student);
			System.out.println("Deserialized");
		}
	}
}
