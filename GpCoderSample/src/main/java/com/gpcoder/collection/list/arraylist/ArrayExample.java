package com.gpcoder.collection.list.arraylist;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayExample {
	public static void main(String[] args) throws Exception {
		ArrayList<String> list = new ArrayList<>(5);
		list.add("Item01");
		list.add("Item02");
		list.add("Item03");
		list.add("Item04");
		list.add("Item05");
		list.add("Item06");
		System.out.format("Size: %d, Capacity: %d%n", list.size(), getCapacity(list));
	}

	public static int getCapacity(ArrayList<?> list) throws Exception {
		Field dataField = ArrayList.class.getDeclaredField("elementData");
		dataField.setAccessible(true);
		return ((Object[]) dataField.get(list)).length;
	}
}
