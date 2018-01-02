package com.gpcoder;

import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {
	public static void main(String[] args) {
		final String str = "hoc lap trinh phai kien tri";
		count(str);
	}

	public static void count(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		char[] chars = str.toCharArray();
		for (char ch : chars) {
			if (ch == ' ') {
				continue;
			}
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		for (Character ch : map.keySet()) {
			if (map.get(ch) >= 2) {
				System.out.printf("%s: %d \n", ch, map.get(ch));
			}
		}
	}
}
