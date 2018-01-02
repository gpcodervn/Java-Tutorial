package com.gpcoder.collection.list.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToArray2 {
	public static void main(String[] args) {
		// Create list
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		// Convert ArrayList to Array
		Integer[] arr = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		// Print data
		System.out.println(Arrays.toString(arr)); // [10, 20, 30, 40]
	}
}
