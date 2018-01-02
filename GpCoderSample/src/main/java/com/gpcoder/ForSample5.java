package com.gpcoder;

public class ForSample5 {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			if (i == 4) {
				continue;
			}
			System.out.print(i + " ");
		}

	}
}