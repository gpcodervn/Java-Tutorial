package com.gpcoder.throwex;

class CustomExceptionExample {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18) {
			throw new InvalidAgeException("not valid");
		} else {
			System.out.println("welcome to vote");
		}
	}

	public static void main(String args[]) {
		try {
			validate(13);
		} catch (Exception m) {
			System.out.println("Exception occured: " + m);
		}

		System.out.println("rest of the code...");
	}
}