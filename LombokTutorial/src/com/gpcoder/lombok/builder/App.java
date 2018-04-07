package com.gpcoder.lombok.builder;

public class App {

	public static void main(String[] args) {
		UserProfileEntity entity = new UserProfileEntity("gpcoder", "Java", 5);
		System.out.println(entity);
		
		UserProfileBuilder builder = UserProfileBuilder.builder()
				.name("gpcoder")
				.language("Java")
				.experience(5)
				.build();
		System.out.println(builder);
	}

}
