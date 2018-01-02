package com.gpcoder;

public class TwoDimensionalSample2 {
	 
    public static void main(String[] args) {
 
        // Khai báo một mảng 2 chiều với 2 dòng, 3 cột
        // Các phần tử có giá trị mặc định
        int[][] arr = new int[2][3];
         
        // Số dòng của mảng 2 chiều.
        System.out.println("Số dòng của mảng 2 chiều: "+ arr.length); // ==> 2
        
        System.out.println("Hiển thị mảng rỗng"); 
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.println("arr[" + row + "," + col + "]=" + arr[row][col]);
            }
        }
        
        System.out.println();
        System.out.println("Khỏi tạo giá trị mảng");  
        // Gán các giá trị cho các phần tử
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = row + col;
            }
        }

        System.out.println();
        System.out.println("Hiển thị giá trị sau khi khởi tạo");  
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.println("arr[" + row + "," + col + "]=" + arr[row][col]);
            }
        }
 
    }
 
}