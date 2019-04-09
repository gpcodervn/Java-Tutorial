package com.gpcoder.abstract_class;

public abstract class AbstractDependent {

	public int callApi(String url) {
		preExecute(url);
		int result = execute(url);
		return postExecute(result);
	}

	protected int execute(String url) {
		if ("gpcoder.com".equals(url)) {
			return 1;
		}
		return 0;
	}

	protected abstract void preExecute(String url);

	protected abstract int postExecute(int result);

}
