package com.gpcoder.csv;

import com.opencsv.bean.CsvBindByPosition;

public class CountryAnn {

	@CsvBindByPosition(position = 0)
	private int id;

	@CsvBindByPosition(position = 1)
	private String code;

	@CsvBindByPosition(position = 2)
	private String name;

	public CountryAnn() {
		super();
	}

	public CountryAnn(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
