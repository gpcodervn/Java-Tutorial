package com.gpcoder.console;

import java.io.Console;

public class PasswordConsoleExample {
	public static void main(String args[]) {
		Console c = System.console();
		System.out.println("Enter password: ");
		char[] ch = c.readPassword();
		// convert char array into string
		String pass = String.valueOf(ch);
		System.out.println("Password is: " + pass);
	}
}
