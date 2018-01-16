package com.gpcoder.gson.exclude;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.User;

public class CustomExclusionStrategyExample {
	public static void main(String args[]) {

		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new CustomExclusionStrategy())
				.setPrettyPrinting()
				.create();

		User user = new User();
		user.setUserName("gpcoder.com");
		user.setPassword("123");
		user.setEmail("gpcodervn@gmail.com");

		// Serialize
		String jsonString = gson.toJson(user);
		System.out.println("JSON : " + jsonString);

		// Deserialize
		String inputJson = "{\"userName\":\"gpcoder.com\",\"password\":\"123\",\"email\":\"gpcodervn@gmail.com\"}";
		user = gson.fromJson(inputJson, User.class);
		System.out.println("Java Object : " + user);

	}
}
