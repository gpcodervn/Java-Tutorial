package com.gpcoder.instance.objenesis;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class ObjenesisExample {

	public static void main(String[] args) {
		// Step 1: Create objenesis
		Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer

		// Step 2: Create instantiator with the specific ProductFactory type
		// Try to reuse the ObjectInstantiator objects as much as possible to improve performance
		// It can be shared between multiple threads and used concurrently
		ObjectInstantiator<?> instantiator = objenesis.getInstantiatorOf(ProductFactory.class);

		// Step 3: Create new instance of the ProductFactory type
		ProductFactory productFactory1 = (ProductFactory) instantiator.newInstance();
		ProductFactory productFactory2 = (ProductFactory) instantiator.newInstance();
		ProductFactory productFactory3 = (ProductFactory) instantiator.newInstance();

		// Step 4: Use the instances
		System.out.println("productFactory1: " + productFactory1);
		System.out.println("productFactory2: " + productFactory2);
		System.out.println("productFactory3: " + productFactory3);
		
		productFactory1.doSomething("factory1");
		productFactory2.doSomething("factory2");
		productFactory3.doSomething("factory3");
	}
}
