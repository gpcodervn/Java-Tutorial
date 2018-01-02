package com.gpcoder.generic;

import java.util.ArrayList;

public class WildCardExample1 {

	public static void main(String[] args) {

		// Một danh sách chứa các phần tử kiểu String.
		ArrayList<String> listString = new ArrayList<String>();

		listString.add("Tom");
		listString.add("Jerry");

		// Một danh sách chứa các phần tử kiểu Integer
		ArrayList<Integer> listInteger = new ArrayList<Integer>();

		listInteger.add(100);

		// Bạn không thể khai báo:
		// ArrayList<Object> list1 = listString; // ==> Error!

		// Một đối tượng kiểu tham số đại diện.
		// (wildcard parameterized object).
		ArrayList<? extends Object> list2;

		// Bạn có thể khai báo:
		list2 = listString;

		// Hoặc
		list2 = listInteger;

	}

}