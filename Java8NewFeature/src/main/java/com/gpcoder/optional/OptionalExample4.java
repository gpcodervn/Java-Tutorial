package com.gpcoder.optional;

import java.util.Optional;

public class OptionalExample4 {

	public static void main(String[] args) {
		Optional<String> optionalOf = Optional.of("welcome to gpcoder.com");
		Optional<String> optionalEmpty = Optional.empty();

		System.out.println(optionalOf.map(String::toLowerCase));
		System.out.println(optionalEmpty.map(String::toLowerCase));

		Optional<Optional<String>> multiOptional = Optional.of(Optional.of("gpcoder"));

		System.out.println("Value of Optional object: " + multiOptional);
		System.out.println("Optional.map: " + multiOptional.map(gender -> gender.map(String::toUpperCase)));
		System.out.println("Optional.flatMap: " + multiOptional.flatMap(gender -> gender.map(String::toUpperCase)));
	}
}
