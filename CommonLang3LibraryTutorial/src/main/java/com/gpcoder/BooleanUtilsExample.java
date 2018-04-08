package com.gpcoder;

import org.apache.commons.lang3.BooleanUtils;

public class BooleanUtilsExample {

	public static void toBoolean() {
		// toBoolean(int value) return true if non-zero, false if zero
		System.out.println(BooleanUtils.toBoolean(0)); // false

		System.out.println(BooleanUtils.toBoolean(1)); // true
		System.out.println(BooleanUtils.toBoolean(2)); // true
		System.out.println(BooleanUtils.toBoolean(-1)); // true
		System.out.println(BooleanUtils.toBoolean(-2)); // true

		// toBoolean(String str): return false if no match or the String is null
		System.out.println(BooleanUtils.toBoolean((String) null)); // false
		System.out.println(BooleanUtils.toBoolean("true")); // true
		System.out.println(BooleanUtils.toBoolean("false")); // false

		System.out.println(BooleanUtils.toBoolean("TruE")); // true
		System.out.println(BooleanUtils.toBoolean("FalsE")); // false

		System.out.println(BooleanUtils.toBoolean("on")); // true
		System.out.println(BooleanUtils.toBoolean("ON")); // true

		System.out.println(BooleanUtils.toBoolean("off")); // false
		System.out.println(BooleanUtils.toBoolean("OFF")); // false

		System.out.println(BooleanUtils.toBoolean("abc")); // false
		System.out.println(BooleanUtils.toBoolean("123")); // false
	}

	public static void toInteger() {
		System.out.println(BooleanUtils.toInteger(true)); // 1
		System.out.println(BooleanUtils.toInteger(false)); // 0
	}

	public static void toStringXXX() {
		System.out.println(BooleanUtils.toStringOnOff(null)); // null
		System.out.println(BooleanUtils.toStringOnOff(Boolean.TRUE)); // on
		System.out.println(BooleanUtils.toStringOnOff(Boolean.FALSE)); // off

		System.out.println(BooleanUtils.toStringTrueFalse(null)); // null
		System.out.println(BooleanUtils.toStringTrueFalse(Boolean.TRUE)); // true
		System.out.println(BooleanUtils.toStringTrueFalse(Boolean.FALSE)); // false

		System.out.println(BooleanUtils.toStringYesNo(null)); // null
		System.out.println(BooleanUtils.toStringYesNo(Boolean.TRUE)); // yes
		System.out.println(BooleanUtils.toStringYesNo(Boolean.FALSE)); // no
	}
}
