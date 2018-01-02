package com.gpcoder;

public class ForSample6 {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			System.out.print(i + ": ");
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.print(j + " ");
			}
			System.out.println(); 
		}

	}
}