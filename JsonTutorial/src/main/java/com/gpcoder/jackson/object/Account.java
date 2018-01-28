package com.gpcoder.jackson.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gpcoder.jackson.annotation.CustomDateDeserializer;
import com.gpcoder.jackson.annotation.CustomDateSerializer;

@JsonIgnoreProperties({ "iban", "pin" })
public class Account {

	@JsonProperty("number")
	private String accountNumber;

	private String iban;

	private String pin;

	@JsonIgnore
	private String owner;

	@JsonProperty
	private String address;

	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date createdDate;

	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date expiredDate;

	private String notAnnotation;

	private String notAnnotationWithSetter;

	@JsonProperty
	private List<String> services = new ArrayList<String>();

	private Map<String, Object> history = new HashMap<String, Object>();

	@JsonAnyGetter
	public Map<String, Object> any() {
		return history;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		history.put(name, value);
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setHistory(Map<String, Object> history) {
		this.history = history;
	}

	public String getNotAnnotationWithSetter() {
		return notAnnotationWithSetter;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", iban=" + iban + ", pin=" + pin + ", owner=" + owner
				+ ", address=" + address + ", createdDate=" + createdDate + ", expiredDate=" + expiredDate
				+ ", notAnnotation=" + notAnnotation + ", notAnnotationWithSetter=" + notAnnotationWithSetter
				+ ", services=" + services + ", history=" + history + "]";
	}

}
