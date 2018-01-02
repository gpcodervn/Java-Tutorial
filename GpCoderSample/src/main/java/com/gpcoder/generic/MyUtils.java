package com.gpcoder.generic;

import java.util.Collection;

public class MyUtils {
	public static <T> int count(Collection<T> collection, T itemToCount) {
		int count = 0;
		for (T item : collection) {
			if (itemToCount.equals(item)) {
				count++;
			}
		}
		return count;
	}
}
