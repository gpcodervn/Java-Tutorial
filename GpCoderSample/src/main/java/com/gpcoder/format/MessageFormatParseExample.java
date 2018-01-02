package com.gpcoder.format;

import java.text.MessageFormat;
import java.text.ParsePosition;

public class MessageFormatParseExample {

	public static void main(String[] args) {
		MessageFormat mf = new MessageFormat("String: {0}\nInteger: {1}\nDouble: {2}");

		Object[] objArray = { "This is a string", new Integer(56), new Double(12.34) };
		String message = mf.format(objArray);

		System.out.println("The message: \n" + message);

		Object[] obj = mf.parse(message, new ParsePosition(0));

		System.out.println("\n\nObjects parsed:");
		for (Object o : obj) {
			System.out.println(o + " of " + o.getClass().toString());
		}

	}

}
