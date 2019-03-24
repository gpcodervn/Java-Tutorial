package com.gpcoder.mockito.whenthen;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DeepStubTest {

	@Test
	public void withoutDeepStubTest() {
		// Create mock object
		Store store = Mockito.mock(Store.class);
		Order order = Mockito.mock(Order.class);
		Customer customer = Mockito.mock(Customer.class);
		BillingAddress billingAddress = Mockito.mock(BillingAddress.class);

		// Configure mock to return a specific value on a method call
		Mockito.when(store.getOrder()).thenReturn(order);
		Mockito.when(order.getCustomer()).thenReturn(customer);
		Mockito.when(customer.getBillingAddress()).thenReturn(billingAddress);
		Mockito.when(billingAddress.getCity()).thenReturn("Can Tho");

		// Verify behavior
		Assert.assertEquals("Can Tho", store.getOrder().getCustomer().getBillingAddress().getCity());
	}

	@Test
	public void deepStubTest() {
		// Create mock object
		Store store = Mockito.mock(Store.class, Mockito.RETURNS_DEEP_STUBS);

		// Configure mock to return a specific value on a method call
		Mockito.when(store.getOrder().getCustomer().getBillingAddress().getCity()).thenReturn("Can Tho");

		// Verify behavior
		Assert.assertEquals("Can Tho", store.getOrder().getCustomer().getBillingAddress().getCity());
	}
}
