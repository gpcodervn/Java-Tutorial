package com.gpcoder.exception;

public class ExceptionExample1 {
	
	public static int getValueAtIndex5() {
		try {
			int arr[] = new int[5];
			arr[5] = 4;
			System.out.println("arr[5] = " + arr[5]);
			return 1;
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex);
			return 0; // Return kết quả nhưng vẫn thực thi khối finally
		} finally {
			System.out.println("Khối lệnh finally luôn được thực thi");
		}
	}

	public static void main(String[] args) {
		System.out.println("getValueAtIndex5() = " + getValueAtIndex5());
	}

}
