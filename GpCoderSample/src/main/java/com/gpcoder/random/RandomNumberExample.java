package com.gpcoder.random;

import java.util.Random;

public class RandomNumberExample {
	
	public static Random generator = new Random();
	
	public static void main(String[] args) {
		System.out.println(randomVerificationCode());
	}

	public static void randomExample1() {
		
		System.out.println("Random Integer: " + generator.nextInt());
		System.out.println("Random Long: " + generator.nextLong());
		System.out.println("Random Float: " + generator.nextFloat());
		System.out.println("Random Double: " + generator.nextDouble());
		System.out.println("Random Boolean: " + generator.nextBoolean());
		
		byte[] bytes = "gpcoder.com".getBytes();
		System.out.println("Before Random Bytes : " + new String(bytes));
		generator.nextBytes(bytes);
		System.out.println("After Random Bytes : " + new String(bytes));
	}
	
	public static void roll() {
		System.out.println(generator.nextInt(4) + 1);
	}
	
	public static void line() {
		double value = generator.nextDouble() * 360.0;
	}
	
	public static int randomNumber(int min, int max) {
		return generator.nextInt((max - min) + 1) + min;
	}
	
	public static int randomVerificationCode() {
		return (int) Math.floor(((Math.random() * 899999) + 100000));
	}
}
