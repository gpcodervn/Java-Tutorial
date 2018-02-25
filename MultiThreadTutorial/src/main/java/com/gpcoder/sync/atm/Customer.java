package com.gpcoder.sync.atm;

public class Customer {
	private int balance = 1000;

	public Customer() {
		System.out.println("Tài khoản của bạn là " + balance);
	}

	public synchronized void withdraw(int amount) {
		System.out.println("Đang thực hiện giao dịch rút tiền " + amount + "...");
		while (balance < amount) {
			System.out.println("Không đủ tiền rút!!!");
			try {
				wait(); // Chờ nạp tiền
			} catch (InterruptedException ie) {
				System.out.println(ie.toString());
			}
		}
		balance -= amount;
		System.out.println("Rút tiền thành công. Tài khoản của bạn hiện tại là " + balance);
	}

	public synchronized void deposit(int amount) {
		System.out.println("Đang thực hiện giao dịch nạp tiền " + amount + "...");
		balance += amount;
		System.out.println("Nạp tiền thành công. Tài khoản của bạn hiện tại là " + balance);
		notify(); // Thông báo đã nạp tiền
	}

}
