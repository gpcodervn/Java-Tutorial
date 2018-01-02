package com.gpcoder;

public class JobTimeDemo {
	 
    // Đây là phương thức tính tổng các số từ 1 tới 100.
    private static int sum() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
 
    private static void doJob(int count) {
        // Gọi phương thức 'sum' với số lần cho bởi tham số.
        for (int i = 0; i < count; i++) {
            sum();
        }
    }
 
    public static void main(String[] args) {
        long millis1 = System.currentTimeMillis();
 
        doJob(10000);
 
        long millis2 = System.currentTimeMillis();
 
        long distance = millis2 - millis1;
 
        System.out.println("Distance time in milli second: " + distance);
    }
}