package com.gpcoder.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample3 {

	public static void main(String[] args) {
		
		List<User> users = Arrays.asList( // 
			new User("gpcoder1", "gpcodervn1@gmail.com", "123"), //	
			new User("gpcoder2", "gpcodervn2@gmail.com", "124"), //	
			new User("gpcoder3", "gpcodervn3@gmail.com", "125") //	
		);

		Function<User, Member> mapUserToMember = u -> new Member(u.name, u.email);

	    List<Member> members = users.stream()
	    		.map(mapUserToMember)
	            .collect(Collectors.toList());
	}
}
