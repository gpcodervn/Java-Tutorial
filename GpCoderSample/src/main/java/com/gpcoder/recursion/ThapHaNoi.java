package com.gpcoder.recursion;

public class ThapHaNoi {
	public static void thapHaNoi(int n, char nguon, char dich, char trungGian) {
	    //điểm neo
	    if (n == 1) {
	    	System.out.println(String.format("Chuyen 1 dia tu %s sang %s", nguon, dich));
	    } else {
	        //chuyển n-1 đĩa từ cọc nguồn sang cọc trung gian,
	        //lấy cọc đích làm cọc phụ
	    	thapHaNoi(n - 1, nguon, trungGian, dich);
	    	
	        //chuyển còn lại từ cọc nguồn sang cọc đích
	        System.out.println(String.format("Chuyen 1 dia tu %s sang %s", nguon, dich));
	        
	        //chuyễn n-1 từ cọc trung gian về cọc đích,
	        //lấy cọc nguồn làm cọc trung gian
	        thapHaNoi(n - 1, trungGian, dich, nguon);
	    }
	}

	public static void main(String[] args) {
		thapHaNoi(5, 'A', 'C', 'B');
	}

}
