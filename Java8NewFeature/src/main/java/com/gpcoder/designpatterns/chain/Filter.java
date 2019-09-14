package com.gpcoder.designpatterns.chain;

public abstract class Filter {

	private Filter nextFilter;

	public String doFilter(String str) {
		String result = handleString(str);
		if (nextFilter != null) {
			return nextFilter.doFilter(result);
		}
		return result;
	}

	public void setNextFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}

	protected abstract String handleString(String str);
}
