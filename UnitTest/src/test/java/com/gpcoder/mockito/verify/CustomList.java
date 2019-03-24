package com.gpcoder.mockito.verify;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomList {

	public static final int TIME_TO_EXECUTE_IN_MILISECONDS = 50;

	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public boolean add(String item) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.MILLISECONDS.sleep(TIME_TO_EXECUTE_IN_MILISECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				getList().add(item);
			}
		});
		t.start();
		return true;
	}
}
