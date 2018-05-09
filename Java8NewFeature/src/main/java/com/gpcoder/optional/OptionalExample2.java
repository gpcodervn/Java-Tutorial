package com.gpcoder.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExample2 {

	public static void main(String[] args) {
		// Pre java 8
		List<String> list = getList();
		List<String> listOpt = list != null ? list : new ArrayList<>();

		// Java 8
		List<String> listOpt2 = getList2().orElse(new ArrayList<>());
		List<String> listOpt3 = getList2().orElseGet(() -> new ArrayList<>());
	}

	private static List<String> getList() {
		return null;
	}

	private static Optional<List<String>> getList2() {
		return null;
	}
}
