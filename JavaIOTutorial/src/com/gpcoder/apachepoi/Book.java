package com.gpcoder.apachepoi;

public class Book {
	private Integer id;
	private String title;
	private Integer quantity;
	private Double price;
	private Double totalMoney;

	public Book() {
		super();
	}

	public Book(Integer id, String title, Integer quantity, double price) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", quantity=" + quantity + ", price=" + price + ", totalMoney="
				+ totalMoney + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

}
