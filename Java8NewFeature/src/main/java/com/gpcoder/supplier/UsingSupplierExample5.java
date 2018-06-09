package com.gpcoder.supplier;

import java.util.function.Supplier;

public class UsingSupplierExample5 {

	public static void main(String[] args) {
		System.out.println("Pre handler eager match");
		boolean b1 = compute("gpcoder");
		boolean b2 = compute("gp");
		System.out.println("Calling eager match");
		String eagerMatch = eagerMatch(b1, b2);
		System.out.println(eagerMatch);
		System.out.println("Post handler eager match");

		System.out.println("-----");
		
		System.out.println("Pre handler lazy match");
		Supplier<Boolean> s1 = () -> compute("gpcoder");
		Supplier<Boolean> s2 = () -> compute("gp");
		System.out.println("Calling lazy match");
		String lazyMatch = lazyMatch(s1, s2);
		System.out.println(lazyMatch);
		System.out.println("Post handler lazy match");
	}

	public static String eagerMatch(boolean b1, boolean b2) {
		System.out.println("Excecuting eager match");
		return b1 && b2 ? "Yes" : "No";
	}

	public static String lazyMatch(Supplier<Boolean> s1, Supplier<Boolean> s2) {
		System.out.println("Excecuting lazy match");
		return s1.get() && s2.get() ? "Yes" : "No";
	}

	public static boolean compute(String str) {
		System.out.println("Computing: " + str);
		return str.contains("gpcoder");
	}
}
