package com.gpcoder;

import org.apache.commons.lang3.time.StopWatch;

public class StringConcatenate {
	public static final int NUM_OF_ITEM = 10000;

	public static void main(String[] args) {
		StopWatch stopwatch = new StopWatch();

		// Concat string using String Object
		stopwatch.start();
		stringConcat();
		stopwatch.stop();
		System.out.println("time taken by StringBuilder : " + stopwatch.getNanoTime() + " nanoseconds");

		// Concat string using StringBuilder
		stopwatch.reset();
		stopwatch.start();
		stringBuilder();
		stopwatch.stop();
		System.out.println("time taken by StringBuilder : " + stopwatch.getNanoTime() + " nanoseconds");

		// Concat string using StringBuffer
		stopwatch.reset();
		stopwatch.start();
		stringBuffer();
		stopwatch.stop();
		System.out.println("time taken by StringBuffer : " + stopwatch.getNanoTime() + " nanoseconds");
	}

	public static String stringConcat() {
		String res = "";
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			res += i;
		}
		return res;
	}

	public static String stringBuilder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			sb.append(i);
		}
		return sb.toString();
	}

	public static String stringBuffer() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < NUM_OF_ITEM; i++) {
			sb.append(i);
		}
		return sb.toString();
	}
}
