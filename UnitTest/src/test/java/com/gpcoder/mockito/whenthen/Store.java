package com.gpcoder.mockito.whenthen;

import lombok.Data;

@Data
class BillingAddress {
	private String city;
}

@Data
class Customer {
	private BillingAddress billingAddress;
}

@Data
class Order {
	private Customer customer;
}

@Data
public class Store {
	private Order order;
}
