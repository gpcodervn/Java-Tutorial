package com.gpcoder.jackson.annotation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
		final String dateString = jsonparser.getText();
		try {
			return dateFormat.parse(dateString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}