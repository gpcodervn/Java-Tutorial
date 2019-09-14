package com.gpcoder.random;

import java.util.UUID;

public class UUIDExample {

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		System.out.println("UUID: " + uuid.toString());
		System.out.println("variant: " + uuid.variant());
		System.out.println("version: " + uuid.version());
	}
}
