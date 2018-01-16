package com.gpcoder.jackson;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gpcoder.jackson.object.Subject;

public class MapExample {
	public static void main(String[] args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		Subject math = new Subject("Math", 10.0f);

		// Convert array object to JSON string
		String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(math);
		System.out.println("JSON: " + jsonInString);

		// Convert a JSON to a Map
		Map<String, Object> map = mapper.readValue(jsonInString, new TypeReference<Map<String, Object>>() {
		});
		System.out.println("Map: " + map);
	}
}