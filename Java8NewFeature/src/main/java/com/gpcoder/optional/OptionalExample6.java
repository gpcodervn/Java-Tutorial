package com.gpcoder.optional;

import java.util.Optional;

public class OptionalExample6 {

	public static void main(String[] args) {
		Optional<String> shouldNotBeEmpty = Optional.empty();
		shouldNotBeEmpty.orElseThrow(() -> new IllegalStateException("Data is not found"));
	}
}
