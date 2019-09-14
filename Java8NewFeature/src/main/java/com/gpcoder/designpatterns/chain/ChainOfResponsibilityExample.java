package com.gpcoder.designpatterns.chain;

class Filter1 extends Filter {
	@Override
	protected String handleString(String str) {
		System.out.println("Filter1: " + str);
		return str + "->Filter1";
	}
}

class Filter2 extends Filter {
	@Override
	protected String handleString(String str) {
		System.out.println("Filter2: " + str);
		return str + "->Filter2";
	}
}

class Filter3 extends Filter {
	@Override
	protected String handleString(String str) {
		System.out.println("Filter3: " + str);
		return str + "->Filter3";
	}
}

class AppFilter {
	public static Filter getFilter() {
		Filter1 filter1 = new Filter1();
		Filter2 filter2 = new Filter2();
		Filter3 filter3 = new Filter3();
		filter1.setNextFilter(filter2);
		filter2.setNextFilter(filter3);
		return filter1;
	}
}

public class ChainOfResponsibilityExample {

	public static void main(String[] args) {
		// Build the chain of responsibility
		Filter filter = AppFilter.getFilter();
		// Execute filter
		String result = filter.doFilter("gpcoder");
		System.out.println("Final data: " + result);
	}
}
