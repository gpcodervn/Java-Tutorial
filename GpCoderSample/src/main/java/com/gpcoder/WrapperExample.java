package com.gpcoder;

public class WrapperExample {
	public static void main(String args[]) {

        int num1 = 1;
        Integer num2 = Integer.valueOf(num1);// đổi int thành Integer
        Integer num3 = num1;// autoboxing, tự động đổi int thành Integer trong nội bộ trình biên dịch
         
        int num4 = num2.intValue();// đổi Integer thành int
        int num5 = num3;// unboxing, tự động đổi Integer thành int trong nội bộ trình biên dịch
    }

}
