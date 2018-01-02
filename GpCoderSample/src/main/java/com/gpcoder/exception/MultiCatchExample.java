package com.gpcoder.exception;

import java.util.List;

public class MultiCatchExample {
	public static void main(String[] args) {
		try {
			List<Integer> list = null;

			Integer num = list.get(1); // NullPointerException, ArrayIndexOutOfBoundsException

			int avg = num / 0; // ArithmeticException

		} catch (NullPointerException ex) {
			System.out.println(ex);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
		} catch (ArithmeticException ex) {
			System.out.println(ex);
		}

		System.out.println("Finished!");
	}
}
