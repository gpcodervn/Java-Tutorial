package com.gpcoder;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsExample {

	public static void abbreviate() {
		// returns the abbreviated String using ellipses
		System.out.println(StringUtils.abbreviate(null, 6)); // null
		System.out.println(StringUtils.abbreviate("", 6)); // ""
		System.out.println(StringUtils.abbreviate("abcdefgh", 6)); // abc...
		System.out.println(StringUtils.abbreviate("abcdefgh", 4));// a...
	}

	public static void capitalize() {
		// capitalizes only the first letter of string
		System.out.println(StringUtils.capitalize(null));
		System.out.println(StringUtils.capitalize(""));
		System.out.println(StringUtils.capitalize("gp coder")); // Gp coder
		System.out.println(StringUtils.capitalize("gp Coder")); // Gp Coder
		System.out.println(StringUtils.capitalize("GP Coder")); // GP Coder
		System.out.println(StringUtils.capitalize("gp coder")); // Gp coder
	}

	public static void appendIfMissing() {
		// A new String if suffix was appended, the same string otherwise.
		System.out.println(StringUtils.appendIfMissing("gpcoder.com", ".com")); // gpcoder.com
	}

	public static void prependIfMissing() {
		// A new String if prefix was prepended, the same string otherwise.
		System.out.println(StringUtils.prependIfMissing("gpcoder.com", "www.")); // www.gpcoder.com
	}

	public static void containsAny() {
		// Checks if the string contains any character in the given set of
		// characters or string.
		String string = "gpcoder.com";
		System.out.println(StringUtils.containsAny(string, 'a', 'b', 'c')); // true
		System.out.println(StringUtils.containsAny(string, 'x', 'y', 'z')); // false
		System.out.println(StringUtils.containsAny(string, "abc")); // true
		System.out.println(StringUtils.containsAny(string, "xyz")); // false
	}

	public static void containsIgnoreCase() {
		System.out.println(StringUtils.containsIgnoreCase("gpcoder.com", "GPCODER")); // true
	}

	public static void countMatches() {
		// Counts how many times the substring appears in the string.
		String string = "welcome to www.gpcoder.com";
		System.out.println(StringUtils.countMatches(string, 'w')); // 4
		System.out.println(StringUtils.countMatches(string, "com")); // 2
	}

	public static void defaultIfEmpty() {
		// returns default string if the given string is empty or null, otherwise
		// returns the same string back
		String defaultString = "gpcoder";
		System.out.println(StringUtils.defaultIfEmpty(null, defaultString)); // gpcoder
		System.out.println(StringUtils.defaultIfEmpty("", defaultString)); // gpcoder
		System.out.println(StringUtils.defaultIfEmpty("   ", defaultString)); // " "
		System.out.println(StringUtils.defaultIfEmpty("java", defaultString)); // java
	}

	public static void defaultIfBlank() {
		// returns default string if the given string is blank or null, otherwise
		// returns the same string back.
		String defaultString = "gpcoder";
		System.out.println(StringUtils.defaultIfBlank(null, defaultString)); // gpcoder
		System.out.println(StringUtils.defaultIfBlank("", defaultString)); // gpcoder
		System.out.println(StringUtils.defaultIfBlank("   ", defaultString)); // gpcoder
		System.out.println(StringUtils.defaultIfBlank("java", defaultString)); // java
	}

	public static void defaultString() {
		// returns an empty string if the given string is null, otherwise returns the
		// same string back.
		String defaultString = "gpcoder";
		System.out.println(StringUtils.defaultString(null, defaultString)); // gpcoder
		System.out.println(StringUtils.defaultString("", defaultString)); // ""
		System.out.println(StringUtils.defaultString("   ", defaultString)); // " "
		System.out.println(StringUtils.defaultString("java", defaultString)); // java
	}

	public static void equalsIgnoreCase() {
		// Compares two CharSequences, returning true if they represent equal sequences
		// of characters, ignoring case.
		System.out.println(StringUtils.equalsIgnoreCase(null, null)); // true
		System.out.println(StringUtils.equalsIgnoreCase(null, "")); // false
		System.out.println(StringUtils.equalsIgnoreCase("", "")); // true
		System.out.println(StringUtils.equalsIgnoreCase("", "        ")); // false
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "gpcoder")); // true
		System.out.println(StringUtils.equalsIgnoreCase("GPCODER", "GPCODER")); // true
	}

	public static void indexOfIgnoreCase() {
		// returns the first index of the search string in the given char sequence
		// irrespective of the case.
		System.out.println(StringUtils.indexOfIgnoreCase(null, null)); // -1
		System.out.println(StringUtils.indexOfIgnoreCase("DBCABCA", "ab")); // 3
		System.out.println(StringUtils.indexOfIgnoreCase("DBCABCA", "Ab")); // 3
		System.out.println(StringUtils.indexOfIgnoreCase("DBCABCA", "ABC")); // 3
	}

	public static void isAlphanumeric() {
		// returns TRUE if the given string contains only alpha numeric characters.
		System.out.println(StringUtils.isAlphanumeric(null)); // false
		System.out.println(StringUtils.isAlphanumeric("")); // false
		System.out.println(StringUtils.isAlphanumeric("  ")); // false
		System.out.println(StringUtils.isAlphanumeric("gpcoder")); // true
		System.out.println(StringUtils.isAlphanumeric("gp coder")); // false
		System.out.println(StringUtils.isAlphanumeric("1234")); // true
		System.out.println(StringUtils.isAlphanumeric("gpcoder90")); // true
	}

	public static void isBlank() {
		// returns TRUE if the given string is blank.
		System.out.println(StringUtils.isBlank(null)); // true
		System.out.println(StringUtils.isBlank("")); // true
		System.out.println(StringUtils.isBlank(" ")); // true
		System.out.println(StringUtils.isBlank("gpcoder")); // false
	}

	public static void isEmpty() {
		// returns TRUE if the given string is empty.
		System.out.println(StringUtils.isEmpty(null)); // true
		System.out.println(StringUtils.isEmpty("")); // true
		System.out.println(StringUtils.isEmpty(" ")); // false
		System.out.println(StringUtils.isEmpty("gpcoder")); // false
	}

	public static void left() {
		// returns the leftmost length characters of given String.
		System.out.println(StringUtils.left(null, 4)); // null
		System.out.println(StringUtils.left("", 4)); // ""
		System.out.println(StringUtils.left("", -1)); // ""
		System.out.println(StringUtils.left("gpcoder", -1)); // ""
		System.out.println(StringUtils.left("gpcoder", 2)); // gp
		System.out.println(StringUtils.left("gpcoder", 4)); // gpco
		System.out.println(StringUtils.left("gpcoder", 7)); // gpcoder
	}

	public static void leftPad() {
		// left padded String or original String if no padding is necessary, return null
		// if null String input
		System.out.println(StringUtils.leftPad("9", 4, "0")); // 0009
		System.out.println(StringUtils.leftPad("99", 4, "0")); // 0099
		System.out.println(StringUtils.leftPad("999", 4, "0")); // 0999
		System.out.println(StringUtils.leftPad("9999", 4, "0")); // 9999
		System.out.println(StringUtils.leftPad("99999", 4, "0")); // 99999
	}

	public static void rightPad() {
		System.out.println(StringUtils.rightPad("9", 4, "0")); // 9000
		System.out.println(StringUtils.rightPad("99", 4, "0")); // 9900
		System.out.println(StringUtils.rightPad("999", 4, "0")); // 9990
		System.out.println(StringUtils.rightPad("9999", 4, "0")); // 9999
		System.out.println(StringUtils.rightPad("99999", 4, "0"));// 99999
	}

	public static void reverse() {
		System.out.println(StringUtils.reverse(null)); // null
		System.out.println(StringUtils.reverse("")); // ""
		System.out.println(StringUtils.reverse("  ")); // " "
		System.out.println(StringUtils.reverse("java")); // avaj
		System.out.println(StringUtils.reverse("gpcoder blog")); // golb redocpg
	}

	public static void trim() {
		System.out.println(StringUtils.trim(null)); // ""
		System.out.println(StringUtils.trim("")); // ""
		System.out.println(StringUtils.trim(" ")); // ""
		System.out.println(StringUtils.trim(" gpcoder.com  ")); // gpcoder.com
	}

	public static void trimToEmpty() {
		// If the string is NULL it returns EMPTY, otherwise trims the string
		System.out.println(StringUtils.trimToEmpty(null)); // ""
		System.out.println(StringUtils.trimToEmpty("")); // ""
		System.out.println(StringUtils.trimToEmpty(" ")); // ""
		System.out.println(StringUtils.trimToEmpty(" gpcoder.com  ")); // gpcoder.com
	}

	public static void trimToNull() {
		// If the result of string after trim is EMPTY it returns NULL, otherwise
		// returns trimmed string
		System.out.println(StringUtils.trimToNull(null)); // null
		System.out.println(StringUtils.trimToNull("")); // null
		System.out.println(StringUtils.trimToNull(" ")); // null
		System.out.println(StringUtils.trimToEmpty(" gpcoder.com  ")); // gpcoder.com
	}
}
