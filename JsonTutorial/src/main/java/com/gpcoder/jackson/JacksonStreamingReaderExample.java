package com.gpcoder.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonStreamingReaderExample {
	public static void main(String[] args) throws IOException {
		File file = new File("data/result.json");

		JsonFactory factory = new JsonFactory();

		/**
		 * Read values in json format
		 */
		JsonParser parser = factory.createParser(file);
		parser.nextToken(); // start reading the file

		while (parser.nextToken() != JsonToken.END_OBJECT) { // loop until "}"
			String name = parser.getCurrentName();

			if (name.equals("name")) {
				parser.nextToken();
				System.out.println(parser.getText());
			} else if (name.equals("website")) {
				parser.nextToken();
				System.out.println(parser.getText());
			} else if (name.equals("year")) {
				parser.nextToken();
				System.out.println(parser.getIntValue());
			} else if (name.equals("posts")) {
				parser.nextToken();
				// it's an array.
				while (parser.nextToken() != JsonToken.END_ARRAY) { // loop until "]"
					System.out.println(parser.getText());
				}
			} else {// unexpected value, skip it or generate error
				// TODO
			}
		}

		parser.close();
	}
}
