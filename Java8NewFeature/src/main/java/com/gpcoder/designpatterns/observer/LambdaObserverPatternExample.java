package com.gpcoder.designpatterns.observer;

public class LambdaObserverPatternExample {
	public static void main(String[] args) {
		AccountService account = new AccountService();
		// Register Observers
		account.registerObserver(str -> System.out.println("Logger: " + str));
		account.registerObserver(str -> System.out.println("Mailer: " + str));
		// Call service
		account.login("gpcoder");
	}
}
