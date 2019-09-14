package com.gpcoder.designpatterns.factory;

class BankFactory {
	public static final Bank getBank(BankType bankType) {
		switch (bankType) {
			case TPBANK:
				return new TPBank();
			case VIETCOMBANK:
				return new VietcomBank();
			default:
				throw new IllegalArgumentException("This bank type is unsupported");
		}
	}
}

public class FactoryMethodExample {
	public static void main(String[] args) {
		Bank bank = BankFactory.getBank(BankType.TPBANK);
		System.out.println(bank.getBankName()); // TPBank
	}
}
