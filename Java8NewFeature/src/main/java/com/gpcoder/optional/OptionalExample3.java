package com.gpcoder.optional;

import java.util.Optional;

class User {

	private Address address;

	public Address getAddress() {
		return address;
	}
}

class Address {

	private String street;

	public String getStreet() {
		return street;
	}
}

public class OptionalExample3 {

	public String getStreetPreJava8() {
		User user = getUser();
		if (user != null) {
			Address address = user.getAddress();
			if (address != null) {
				String street = address.getStreet();
				if (street != null) {
					return street;
				}
			}
		}
		return "not specified";
	}

	public String getStreetJava8() {
		Optional<User> user = Optional.ofNullable(getUser());
		return user.map(User::getAddress)
				.map(Address::getStreet)
				.orElse("not specified");
	}

	private static User getUser() {
		return null;
	}
}
