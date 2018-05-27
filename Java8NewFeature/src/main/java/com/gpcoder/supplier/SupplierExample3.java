package com.gpcoder.supplier;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;

class NumberUtils {

	public static boolean getBooleanValue() {
		return true;
	}

	public static int getIntValue() {
		return 1;
	}

	public static long getLongValue() {
		return 2;
	}

	public static double getDoubleValue() {
		return 3;
	}
}
public class SupplierExample3 {

	public static void main(String[] args) {

		BooleanSupplier bs = NumberUtils::getBooleanValue;
		System.out.println("Boolean Value: " + bs.getAsBoolean());

		IntSupplier dbs = NumberUtils::getIntValue;
		System.out.println("Integer Value: " + dbs.getAsInt());

		LongSupplier ls = NumberUtils::getLongValue;
		System.out.println("Long Value: " + ls.getAsLong());

		DoubleSupplier ds = NumberUtils::getDoubleValue;
		System.out.println("Double Value: " + ds.getAsDouble());
	}
}
