package com.gpcoder.gson.annotation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gpcoder.gson.object.Account;

public class ExposeExample {
	public static void main(final String[] args) throws Exception {
		final GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		final Gson gson = builder.create();

		final Account account = new Account();
		account.setAccountNumber("A123 4567 8909");
		account.setIban("IB 11 22 33 44");
		account.setOwner("GP Coder");
		account.setPin("123456");
		account.setAddress("Can Tho, Viet Nam");

		final String json = gson.toJson(account);
		System.out.println("Json: " + json);
 
		String json2 = "{\"accountNumber\":\"A123 4567 8909\",\"iban\":\"IBAN 11 22 33 44\",\"owner\":\"GP Coder\",\"pin\":\"123456\",\"address\":\"Can Tho, Viet Nam\"}";
		final Account account2 = gson.fromJson(json2, Account.class);
		System.out.println("Java Object: ");
		System.out.printf("  + Account Number: %s%n", account2.getAccountNumber());
		System.out.printf("  + IBAN:           %s%n", account2.getIban());
		System.out.printf("  + Owner:          %s%n", account2.getOwner());
		System.out.printf("  + Pin:            %s%n", account2.getPin());
		System.out.printf("  + Address:        %s%n", account2.getAddress());
	}
}
