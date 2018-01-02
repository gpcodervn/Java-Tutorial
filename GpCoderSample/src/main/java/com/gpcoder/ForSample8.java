package com.gpcoder;

public class ForSample8 {
	public static void main(String[] args) {
		int i;
		final int COUNT = 5;
		System.out.print("Using For:   ");
		i = 1;
		for (;;) {
			System.out.print(i + " ");
			if (i == COUNT) {
				break;
			}
			i++;
		}

		System.out.println();
		System.out.print("Using While: ");
		i = 1;
		while (i <= COUNT) {
			System.out.print(i + " ");
			i++;
		}
	}
}
