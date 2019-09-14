package com.gpcoder.designpatterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class Java8BankFactory {
	
	private final static Map<BankType, Supplier<Bank>> map = new HashMap<>();
	
	static {
		map.put(BankType.TPBANK, TPBank::new);
		map.put(BankType.VIETCOMBANK, VietcomBank::new);
	}
	
	public static final Bank getBank(BankType bankType) {
		Supplier<Bank> bank = map.get(bankType);
		if (bank == null) {
			throw new IllegalArgumentException("This bank type is unsupported");
		}
		return bank.get();
	}
}

public class Java8FactoryMethodExample {
	public static void main(String[] args) {
		Bank bank = Java8BankFactory.getBank(BankType.TPBANK);
		System.out.println(bank.getBankName()); // TPBank
	}
}
