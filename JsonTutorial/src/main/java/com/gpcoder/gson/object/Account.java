package com.gpcoder.gson.object;

import com.google.gson.annotations.Expose;

public class Account {
	@Expose(deserialize = false)
	private String accountNumber;

	@Expose
	private String iban;

	@Expose(serialize = false)
	private String owner;

	@Expose(serialize = false, deserialize = false)
	private String address;

	private String pin;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
