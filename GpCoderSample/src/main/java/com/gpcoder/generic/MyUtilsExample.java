package com.gpcoder.generic;

import java.util.ArrayList;
import java.util.List;

public class MyUtilsExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("A");
		list.add("C");
		System.out.println(MyUtils.count(list, "A")); // 2
	}
}
