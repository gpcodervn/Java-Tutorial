package com.gpcoder.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class AccountService implements Subject {

	private final List<Observer> observers = new ArrayList<>();

	public void login(String username) {
		System.out.println("Login: " + username);
		notifyObservers(username);
	}

	@Override
	public void registerObserver(Observer observer) {
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	@Override
	public void notifyObservers(String str) {
		for (Observer observer : observers) {
			observer.update(str);
		}
	}
}
