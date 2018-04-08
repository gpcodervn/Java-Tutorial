package com.gpcoder;

import org.apache.commons.lang3.text.WordUtils;

public class WordUtilsExample {

	public static void capitalize() {
		System.out.println(WordUtils.capitalize(null)); // null
		System.out.println(WordUtils.capitalize("")); // ""
		System.out.println(WordUtils.capitalize("java")); // Java
		System.out.println(WordUtils.capitalize("jAVa")); // JAVa
		System.out.println(WordUtils.capitalize("tutorials from gpcoder.com"));
	}

	public static void capitalizeFully() {
		System.out.println(WordUtils.capitalizeFully(null)); // null
		System.out.println(WordUtils.capitalizeFully("")); // ""
		System.out.println(WordUtils.capitalizeFully("java")); // Java
		System.out.println(WordUtils.capitalizeFully("welcome to gpcoder.com")); // Welcome To Gpcoder.com
		System.out.println(WordUtils.capitalizeFully("tutorials FROM GPCoder.com")); // Tutorials From Gpcoder.com
	}
}
