package com.gpcoder.designpatterns.observer;

class Logger implements Observer {
	@Override
	public void update(String str) {
		System.out.println("Logger: " + str);
	}
}

class Mailer implements Observer {
	@Override
	public void update(String str) {
		System.out.println("Mailer: " + str);
	}
}

public class ObserverPatternExample {
	public static void main(String[] args) {
		AccountService account = new AccountService();
		// Register Observers
		account.registerObserver(new Logger());
		account.registerObserver(new Mailer());
		// Call service
		account.login("gpcoder");
	}
}
