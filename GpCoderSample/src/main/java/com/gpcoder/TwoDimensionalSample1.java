package com.gpcoder;

public class TwoDimensionalSample1 {

	public static void main(String[] args) {

		// Khai báo một mảng 2 chiều (Mảng của mảng)
		// Khởi tạo mảng có 2 dòng
		int[][] arr = new int[2][];

		// Khởi tạo giá trị cho phần từ thứ 2
		arr[0] = new int[] { 
				1, 2
		};

		// Khởi tạo giá trị cho phần tử thứ nhất
		arr[1] = new int[] { 1, 2, 3, 4 };

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.println("Giá trị tại [" + row + "][" + col + "]=" + arr[row][col]);
			}
		}
	}

}