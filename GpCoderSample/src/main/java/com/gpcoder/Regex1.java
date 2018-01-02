package com.gpcoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
	public static void main(String[] args) {
		String str = "Welcome	to gpcoder";
		
		// Ký tự bất kỳ xuất hiện nhiều lần lần và kết thúc là r
		String regex = ".*r$";

		// Tạo đối tượng Pattern thông qua method tĩnh.
		Pattern pattern = Pattern.compile(regex);
		
		// Lấy ra đối tượng Matcher
		Matcher matcher = pattern.matcher(str);
		
		// Kiểm tra có khơp với regex không
		boolean match = matcher.matches();
		System.out.println("Match = " + match); // Match = true
	}
}
