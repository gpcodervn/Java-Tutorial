package com.gpcoder.function;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

public class FunctionExample5 {

	public static void main(String[] args) {

		IntFunction<String> ifunc = (x) -> Integer.toString(x * x);
		LongFunction<String> lfunc = (x) -> Long.toString(x * x);
		DoubleFunction<String> dfunc = (x) -> Double.toString(x * x);

		System.out.println(ifunc.apply(3)); // 9
		System.out.println(lfunc.apply(5)); // 25
		System.out.println(dfunc.apply(10)); // 100.0
	}
}
