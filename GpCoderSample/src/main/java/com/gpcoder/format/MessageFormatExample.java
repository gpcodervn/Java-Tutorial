package com.gpcoder.format;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatExample {

	public static void main(String[] args) {

		int planet = 7;
		String event = "a disturbance in the Force";
		String pattern = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.";

		String output = MessageFormat.format(pattern, planet, new Date(), event);
		System.out.println(output);
	}

}