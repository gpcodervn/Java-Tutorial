package com.gpcoder.spi;

import java.util.List;

public class FullTextSearchService implements SearchService {

	@Override
	public List<Result> search(String text) {
		System.out.println("FullTextSearchService#search()");
		return null;
	}
}
