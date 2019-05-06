package com.gpcoder.spi;

import java.util.ServiceLoader;

public class ServiceLoaderExample {
	public static void main(String[] args) {
		System.out.println("App started ");

		ServiceLoader<SearchService> providers = ServiceLoader.load(SearchService.class);
		for (SearchService provider : providers) {
			provider.search("");
		}

		System.out.println("App finished ");
	}
}
