package com.gpcoder.gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MapExample {
	public static void main(String[] args) {
        Map<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("name", "GP Coder");
        inputMap.put("site", "https://gpcoder.com");
        System.out.println("Input Map: " + inputMap);
        
		Gson gson = new Gson();
		// Serialization
        String json = gson.toJson(inputMap);
        System.out.println("Json: " + json); // {"site":"https://gpcoder.com","name":"GP Coder"}

		// Deserialization
		Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
		Map<String, String> outputMap = gson.fromJson(json, mapType);
        System.out.println("Output Map: " + outputMap);
	}
}
