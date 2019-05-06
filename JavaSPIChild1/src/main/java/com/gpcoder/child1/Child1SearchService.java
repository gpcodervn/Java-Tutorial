package com.gpcoder.child1;

import java.util.List;

import com.gpcoder.spi.Result;
import com.gpcoder.spi.SearchService;

public class Child1SearchService implements SearchService {

	@Override
	public List<Result> search(String text) {
		System.out.println("Child1SearchService#search()");
		return null;
	}
}