package com.gpcoder.designpatterns.observer;

public interface Subject {

	void registerObserver(Observer observer);

	void notifyObservers(String str);
}
