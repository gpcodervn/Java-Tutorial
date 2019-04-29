package com.gpcoder;

import java.text.MessageFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppController {

	private static final Logger LOGGER = LogManager.getLogger(AppController.class);

	public static void main(String[] args) {
		LOGGER.debug("Debug log message");
		divide(4, 2);
		divide(4, 0);
		LOGGER.fatal("Fatal log message");
	}

	public static void divide(int number1, int number2) {
		try {
			int number = number1 / number2;
			LOGGER.info("Info: {} / {} = {}", number1, number2, number);
		} catch (ArithmeticException e) {
			String message = MessageFormat.format("Error: Cannot divide two number {0}/{1}", number1, number2);
			LOGGER.error(message, e);
		}
	}
}
