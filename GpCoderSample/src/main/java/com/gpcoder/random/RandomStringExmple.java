package com.gpcoder.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class RandomStringExmple {

	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
	private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
	private static final String digits = "0123456789"; // 0-9
	private static final String specials = "~=+%^*/()[]{}/!@#$?|";
	private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
	private static final String ALL = alpha + alphaUpperCase + digits + specials;

	private static Random generator = new Random();

	/**
	 * Random string with a-zA-Z0-9, not included special characters
	 */
	public String randomAlphaNumeric(int numberOfCharactor) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCharactor; i++) {
			int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
			char ch = ALPHA_NUMERIC.charAt(number);
			sb.append(ch);
		}
		return sb.toString();
	}

	/**
	 * Random string password with at least 1 digit and 1 special character
	 */
	public String randomPassword(int numberOfCharactor) {
		List<String> result = new ArrayList<>();
		Consumer<String> appendChar = s -> {
			int number = randomNumber(0, s.length() - 1);
			result.add("" + s.charAt(number));
		};
		appendChar.accept(digits);
		appendChar.accept(specials);
		while (result.size() < numberOfCharactor) {
			appendChar.accept(ALL);
		}
		Collections.shuffle(result, generator);
		return String.join("", result);
	}

	public static int randomNumber(int min, int max) {
		return generator.nextInt((max - min) + 1) + min;
	}
	
	public static void main(String a[]){
		int numberOfCharactor = 8;
		RandomStringExmple rand = new RandomStringExmple();
		
        System.out.println("randomString1: " + rand.randomAlphaNumeric(numberOfCharactor));
        System.out.println("randomString1: " + rand.randomAlphaNumeric(numberOfCharactor));
        System.out.println("randomString1: " + rand.randomAlphaNumeric(numberOfCharactor));
        
        System.out.println("randomPassword1: " + rand.randomPassword(numberOfCharactor));
        System.out.println("randomPassword2: " + rand.randomPassword(numberOfCharactor));
    }
}
