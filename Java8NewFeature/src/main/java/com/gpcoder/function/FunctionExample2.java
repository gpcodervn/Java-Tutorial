package com.gpcoder.function;

import java.util.function.Function;

class User {
	String name;
	String email;
	String password;

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
}

class Member {
	String name;
	String email;

	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", email=" + email + "]";
	}
}

public class FunctionExample2 {

	public static void main(String[] args) {

		Function<User, Member> mapUserToMember = u -> new Member(u.name, u.email);

		User user = new User("gpcoder", "gpcodervn@gmail.com", "123");
		Member member = mapUserToMember.apply(user);
		System.out.println(member);
	}
}
